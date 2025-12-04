$headers = @{
    "Content-Type" = "application/json"
}
$regBody = '{
    "nom": "testdirect",
    "email": "testdirect@example.com",
    "password": "password123",
    "role": "USER"
}'
$loginBody = '{
    "nom": "testdirect",
    "password": "password123"
}'

Write-Host "--- 1. Registering Direct (8081) ---"
try {
    $regResponse = Invoke-WebRequest -Uri "http://localhost:8081/auth/register" -Method POST -Headers $headers -Body $regBody
    Write-Host "Registration Status: $($regResponse.StatusCode)"
    Write-Host "Response: $($regResponse.Content)"
} catch {
    Write-Host "Registration Failed: $_"
    if ($_.Exception.Response) {
        Write-Host "Status: $($_.Exception.Response.StatusCode)"
    }
}

Write-Host "`n--- 2. Login Direct (8081) ---"
try {
    $loginResponse = Invoke-WebRequest -Uri "http://localhost:8081/auth/token" -Method POST -Headers $headers -Body $loginBody
    Write-Host "Login Status: $($loginResponse.StatusCode)"
    Write-Host "Token: $($loginResponse.Content)"
} catch {
    Write-Host "Login Failed: $_"
    if ($_.Exception.Response) {
        Write-Host "Status: $($_.Exception.Response.StatusCode)"
    }
}
