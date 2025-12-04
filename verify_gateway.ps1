$headers = @{
    "Content-Type" = "application/json"
}
$loginBody = '{
    "nom": "testdirect",
    "password": "password123"
}'

Write-Host "--- Login via Gateway (8088) ---"
try {
    $loginResponse = Invoke-WebRequest -Uri "http://localhost:8088/user-service/auth/token" -Method POST -Headers $headers -Body $loginBody
    Write-Host "Login Status: $($loginResponse.StatusCode)"
    Write-Host "Token: $($loginResponse.Content)"
} catch {
    Write-Host "Login Failed: $_"
    if ($_.Exception.Response) {
        Write-Host "Status: $($_.Exception.Response.StatusCode)"
    }
}
