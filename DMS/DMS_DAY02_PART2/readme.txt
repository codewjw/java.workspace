完成test包中的测试用例Part1中的方法sendLogs
当测试完毕后，将实现定义在DMSClient同名方法

注:当前项目src/test/resourecs目录中有一个logrec_review.txt
文件。该文件是logrec.txt的一个副本。因为sendLogs方法执行完毕后
会将该文件删除。所以若在调试代码过程中出现将该文件删除
导致无法继续测试时，可以自行再创建出logrec.txt文件，内容
则使用logrec_review.txt中内容即可。


最终结果:
根据需求写好方法后，首先运行当前目录下的DMSServer类
然后运行当前测试用例，查看DMSServer控制台输出的结果。
结果应为:
等待客户端连接...
客户端连接了,开始接收客户端发送的日志...
接收到配对日志:huangr,12348,7,1377537895,192.168.1.38|huangr,12348,8,1377541495,192.168.1.38
接收到配对日志:guojing,12341,7,1377660105,192.168.1.34|guojing,12341,8,1377666173,192.168.1.34
所有日志均已接收完毕!
响应客户端结果:OK

当全部完成后，运行DMSClient类，项目中应当
会出现两个文件:
1:last-position.txt，内容为:3720

2:login.txt,内容为6条日志信息，内容为:
  baizt,16321,7,1376331705,192.168.1.78
  luwsh,12356,7,1377645205,192.168.1.45
  luxiucai,21356,7,1377663394,192.168.1.62
  tongxy,15332,7,1376446317,192.168.1.65
  lidz,441232,7,1375334515,192.168.1.61
  moxb,23123,7,1377441617,192.168.1.69
  
  
注:若执行完毕后结果不对，在修改完代码准备再次测试前，应当先将生成的这两个
     文件(last-position.txt,login.txt)删除，然后再次测试。
  