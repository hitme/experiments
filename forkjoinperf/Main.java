import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhoudazhuang on 14-8-15.
 * jdk1.7以及一下
 * new Runnable() {
@Override
public void run() {

}
jdk1.8可使用lambda
() -> {}
 * 1. javac Main.java
 * 2. java Main(java二进制字节码,这样就可以运行了 不过这里再准备打包成运行jar包)
 * 3. jar -cvf my.jar *.class
 * 4.  time java -server -jar my.jar my.jar中没有主清单属性 修改压缩jar中MANIFEST.MF添加Main-Class:要空一格Main(主类class名字，有包加包 或者第二种方法直接在参数中指定)
 * 5. 改好后使用 time java -server -jar my.jar 或者直接使用time java -cp ./my.jar Main //主要不要用-jar了 -cp 目录和zip/jar文件的类搜索路径 直接指定就可以了
 * 输出
 * # time java -server -jar my.jar
 * elapsed time: 0.041s
 *  java -server -jar my.jar  0.26s user 0.01s system 215% cpu 0.126 total
 * time ls; time java是linux命令 不用-server我感觉输出也一样
 */
public class Main {
    private static final int TIMES = 100 * 1000 * 100;
    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        long t1 = System.currentTimeMillis();
        for (int i=0;i<TIMES;i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {

                }
            });
        }
        service.shutdown();
        long t2 = System.currentTimeMillis();
        System.out.printf("elapsed time: %.3fs\n", (t2-t1)/1000f);
    }
}
