CREATE DATABASE db_example;
CREATE USER 'springuser'@'%' identified by 'ThePassword';
GRANT ALL ON db_example.* TO 'springuser'@'%';
FLUSH PRIVILEGES;


$postParams = @{name='First';email='name@company.com'}
$postParams = @{name='Second';email='second@company.com'}
$postParams = @{name='Third';email='third@company.com'}
$postParams = @{name='Foutth';email='fourth@company.com'}
$postParams = @{name='Fifth';email='fifth@company.com'}

Invoke-WebRequest -Uri http://localhost:8080/spring-mysql/demo/add -Method POST -Body $postParams
Invoke-WebRequest -Uri http://localhost:8080/spring-mysql/demo/all


-- BEFORE PRODUCTION
REVOKE ALL ON db_example.* FROM 'springuser'@'%';
GRANT SELECT, INSERT, DELETE, UPDATE ON db_example.* TO 'springuser'@'%';
FLUSH PRIVILEGES;
