1.  Lambda表达式：
        Lambda表达式是对象, 是一个函数式接口的实例。
    lambda表达式的使用范围：
        所有的函数式接口, 非函数式接口不能使用Lambda表达式。使用Lambda表达式可以避免使用匿名内部类。
2.  函数式接口：
        只有一个抽象方法的接口是函数式接口。(不包括Object类的抽象方法, 例如Object类的hashCode()方法)。
    注明函数式接口的注解：
        @FunctionalInterface
    Runnable/Callable/Comparator接口就是函数式接口。
3.  Lambda表达式的语法：
        LambdaParameters -> LambdaBody
        参数              -> body体, 抽象方法的实现逻辑, 即Lambda体
        参数的个数由函数式接口里抽象方法的参数个数来决定。
    案例：
        () -> {}                                                //无参, 无返回值
        () -> {System.out.println("a");}                        //无参, 无返回值
        () -> System.out.println("a")                           //无参, 无返回值, 上面的简写
        () -> {return 100;}                                     //无参, 有返回值
        () -> 100                                               //无参, 有返回值, 上面的简写
        (x) -> {return x + 1;}                                  //单个参数, 有返回值
        x -> x + 1                                              //单个参数, 有返回值, 上面的简写
4.  Lambda表达式body体里如果使用外部的变量, 外部的变量必须是final修饰的。如果是body体里的局部变量则无所谓。
5.  任何方法的引用都有对应的Lambda表达式
    方法的引用：
        方法引用是用来直接访问类或者实例的已经存在的方法或者构造方法。方法引用提供了一种引用而不执行方法的方式。
    方法引用使用场景：
        如果函数式接口的抽象方法的实现恰好可以调用另外一个方法来实现, 就有可能(是有可能)使用方法的引用。
    方法引用的语法：
            类型                  语法                  对应的Lambda表达式
        1). 静态方法引用      类名::静态方法            (args) -> 类名::静态方法(args)
        2). 实例方法引用      实例::实例方法            (args) -> 实例::实例方法(args)
        3). 对象方法引用      类名::实例方法            (实例, args) -> 类名::实例方法(args)
        4). 构造方法引用      类名::new                (args) -> new 类名(args)
        其中对象方法引用的语法最为麻烦, 对象方法引用时, 抽象方法的第一个参数类型刚好是实例方法的类型, 抽象方法剩余的参数恰好可以当作实例方法
    的参数。如果函数式接口的实现能由上面说的实例方法调用来实现的话, 那么就可以使用对象方法引用。
        对方法的引用不熟时, 可以在写完Lambda表达式后看一下是否可以再次写成方法的引用。
6.  Stream特性
        1)  支持并行
        2)  很容易生成数组或集合
        3)  支持过滤/查找/转换/汇总/聚合等操作
        4)  不支持索引访问
7.  Stream常见API
    中间操作：
        filter                                          过滤
        distinct                                        去重
        sorted                                          排序
        limit skip                                      截取
        map/flatMap                                     转换
        peek                                            其他
    终止操作：
        forEach                                         循环
        min/max/count/average                           计算
        anyMatch/allMatch/noneMatch/findFirst/findAny   匹配
        reduce                                          汇聚
        toArray collect                                 收集器
    Stream的创建：
        1)  通过数组
        2)  通过集合
        3)  通过Stream.generate方法来创建
        4)  通过Stream.iterate方法创建
        5)  其他API创建
        创建Stream时, 前两种方式是用的最多的。
    如果Stream只有中间操作, 没有终止操作, 则该Stream不会被执行。





























































