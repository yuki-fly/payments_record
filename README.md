开发工具：eclipse
使用maven构建
逻辑：
1、存放所有货币与金额的map
2、启动定时任务，1分钟打印map结果一次
3、当需要文件时，分行读取文件中的内容，切割分开货币与金额，并把以货币为key,数值直接求和，存进map中
4、分行读取console的值，
（1）判断是否quit，是停止程序
（2）判断数据格式是否是货币+空格+金额（是否分割成功，是否金额转换成功），若不是，提示“error input with "+ 行内容 +",Please re-enter ”
（3）切割分开货币与金额，并把以货币为key,数值直接求和，存进map中
主要实现代码
com.icss.payments.record.util
-------------------------------QuartzUtil.java 定时任务处理的工具类
-------------------------------PrintJob.java  job打印数据处理
-------------------------------ConsoleReadUtil.java 读取console的值处理
-------------------------------FileReadUtil.java 读取文件的内容处理
-------------------------------DataCaculateUtil.java 计算货币的总金额

测试类
com.icss.payments.record
-------------------------------ConsoleTest.java 控制台输入输出测试类
-------------------------------FileAndConsoleTest.java 文件预输入以及控制台输入输出测试类