二、Activity启动模式：
1.默认启动模式——standard
Activity的默认模式就是standard。在该模式下，启动的Activity会依照启动顺序被依次压入Task中：

2.栈顶复用模式——singleTop
在该模式下，如果栈顶Activity为我们要新建的Activity（目标Activity），那么就不会重复创建新的Activity。

3.栈内复用模式——singleTask
与singleTop模式相似，只不过singleTop模式是只是针对栈顶的元素，而singleTask模式下，如果task栈内存在目标Activity实例，将task内的对应Activity实例之上的所有Activity弹出栈， 将对应Activity置于栈顶，获得焦点。

4.全局唯一模式——singleInstance
在该模式下，我们会为目标Activity分配一个新的affinity，并创建一个新的Task栈，将目标Activity放入新的Task，并让目标Activity获得焦点。新的Task有且只有这一个Activity实例。 如果已经创建过目标Activity实例，则不会创建新的Task，而是将以前创建过的Activity唤醒（对应Task设为Foreground状态）
————————————————
版权声明：本文为CSDN博主「瑾珮」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_44870139/article/details/112734363