$username = "iwan" 
$password = "xiaohui20001206" 
$secure = $password | ConvertTo-SecureString -AsPlainText -Force 
$cred = New-Object System.Management.Automation.PSCredential($username, $secure) 
New-SSHSession -ComputerName 47.98.63.92 -Credential $cred -AcceptKey 
Invoke-SSHCommand -SessionId 0 -Command "cd /home/iwan/etc/;supervisorctl stop multhelp;" #停止进程
Invoke-SSHCommand -SessionId 0 -Command "cd /home/iwan/apps/multhelp/RuoYi-Vue/;git pull;" #pull新代码
Invoke-SSHCommand -SessionId 0 -Command "cd /home/iwan/apps/multhelp/RuoYi-Vue/;mvn clean package  '-Dmaven.test.skip=true';" #更新jar包
Invoke-SSHCommand -SessionId 0 -Command "cd /home/iwan/apps/multhelp/RuoYi-Vue/ruoyi-ui/;npm run build:prod" #更新前端页面
Invoke-SSHCommand -SessionId 0 -Command "cd /home/iwan/etc/;supervisorctl start multhelp;" #重新启动进程
Remove-SSHSession -Index 0 -Verbose