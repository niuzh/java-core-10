/**
 * 并发:进程和线程的区别。
 * 	知识点记忆路线：创建一个线程，然后中断该线程，考虑过程中线程的状态和属性，以及异常处理。
 * 什么是线程：使用线程给其他任务提供机会
 * 	通过两个demo演示了非线程程序和线程程序的区别和线程的简单使用。
 * 中断线程:向线程发送中断请求。
 * 线程状态：介绍了线程的各种状态。
 * 	新创建线程
 * 	可运行线程
 * 	被阻塞线程和等待线程
 * 	被终止的线程
 * 线程属性
 * 	线程优先级：依赖与宿主机系统。注意，不要将程序的功能正确性依赖与线程优先级。
 * 	守护线程：为其他线程提供服务。
 * 	未捕获异常处理器
 * 同步：多个线程共享同一数据的存取。
 * 	竞争条件的一个例子：使用一个银行存取款例子说明多个线程操作时发生错误说明多线程注意事项。
 * 	竞争条件详解：线程执行过程中被中断。
 * 	锁对象(1 synchronized方法关键字，2 ReetrantLock锁对象)
 * 	条件对象:锁对象创建条件对象，条件不满足时，阻塞当前线程，并放弃锁。
 * 	synchronized 关键字
 * 	同步阻塞
 * 	监视器概念
 * 	Volatile域：为实例域的同步访问提供了一种免锁机制。如果声明一个域为 volatile ,那么编译器和虚拟机就知道该域是可能被另一个线程并发更新的 。
 * 	final变量
 * 	原子性
 * 	死锁：所有线程都被阻塞。
 * 	线程局部变量：使用ThreadLoacl辅助类为每个线程提供各自的实例。如果使用同步则开销太大。
 * 	锁测试与超时
 * 	读/写锁：读线程共享，写线程互斥访问。
 * 	为什么要弃用stop和suspend方法
 * 阻塞队列：用于协调多个线程之间的合作。
 * 线程安全的集合：java提供了一些多线程操作安全的队列。
 * 	高效的映射、集和队列
 * 	映射条目的原子更新
 * 	对并发散列映射的批操作
 * 	并发集视图
 * 	写数组的拷贝
 * 	并行数组算法
 * 	较早的线程安全集合(Vector和Hashtable)
 * Callable与Future：通过一个例子演示了并行计算后结果汇总。
 * 执行器：构建线程浪费资源，如果需要大量生命期短的线程则使用线程池。减少并发线程的数目。
 * 	线程池
 * 	预定执行：java.util.Timer的泛化
 * 	控制任务组：把一组相关任务放在一个线程池中进行控制。
 * 	Fork-Join框架：用于把任务分解为子任务并返回汇总结果。
 * 同步器：为线程之间的共用集结点模式提供的预置功能。多个线程之间相互配合作业。
 * 	信号量：一个信号量管理许多许可证。
 * 	倒计时门栓(CountDownLatch)：使用场景，一个线程需要一些初始数据工作，而另一个线程把数据准备好后设置门栓记数为0，则第一个线程可以继续运行。
 * 	障栅(CyclicBarrier):用于汇总结果，当所有线程都到达障栅处时，障栅就撤销，线程继续运行。
 * 	交换器
 * 	同步队列：将生产者消费者配对的机制。
 * 线程与Swing
 * 	运行耗时的任务
 * @author niuzhihuan
 */
package ch14;