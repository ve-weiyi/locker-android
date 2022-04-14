/**
 * @Description hello word!
 * @Author weiyi
 * @Date 2022/3/24
 */

/**
 * app壳工程是从名称来解释就是一个空壳工程，没有任何的业务代码，也不能有Activity，但它又必须被单独划分成一个组件，而不能融合到其他组件中，是因为它有如下几点重要功能：
 * 1、app壳工程中声明了我们Android应用的 Application，这个 Application 必须继承自 Common组件中的
 * BaseApplication（如果你无需实现自己的Application可以直接在表单声明BaseApplication），
 * 因为只有这样，在打包应用后才能让BaseApplication中的Context生效，当然你还可以在这个 Application中初始化我们工程中使用到的库文件，
 * 还可以在这里解决Android引用方法数不能超过 65535 的限制，对崩溃事件的捕获和发送也可以在这里声明。
 *
 * 2、app壳工程的 AndroidManifest.xml 是我Android应用的根表单，应用的名称、图标以及是否支持备份等等属性都是在这份表单中配置的，
 * 其他组件中的表单最终在集成开发模式下都被合并到这份 AndroidManifest.xml 中。
 *
 * 3、app壳工程的 build.gradle是比较特殊的，app壳不管是在集成开发模式还是组件开发模式，它的属性始终都是：com.android.application，因为最终其他的组件都要被app壳工程所依赖，
 * 被打包进app壳工程中，这一点从组件化工程模型图中就能体现出来，所以app壳工程是不需要单独调试单独开发的。
 * **另外Android应用的打包签名，混淆，以及buildTypes和defaultConfig都需要在这里配置**，
 * 而它的dependencies则需要根据isModule的值分别依赖不同的组件，在组件开发模式下app壳工程只需要依赖Common组件，
 * 或者为了防止报错也可以根据实际情况依赖其他功能组件，而在集成模式下app壳工程必须依赖所有在应用Application中声明的业务组件，并且不需要再依赖任何功能组件。
 */

/**
 *
 * 功能组件可能会存在多个，如：画廊组件，分享组件，支付组件，评论反馈组件等，每一个功能组件都可以被一个或者多个不同的业务组件依赖。
 * 功能组件的特征如下：
 *
 * 1，功能组件的 AndroidManifest.xml 是一张空表，这张表中只有功能组件的包名；
 * 2、功能组件不管是在集成开发模式下还是组件开发模式下属性始终是： com.android.library，所以功能组件是不需要读取 gradle.properties 中的 isModule 值的；
 * 另外功能组件的 build.gradle 也无需设置 buildTypes ，只需要 dependencies 这个功能组件需要的jar包和开源库。
 */