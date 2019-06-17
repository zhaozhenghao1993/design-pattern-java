// 日志记录器接口: 抽象产品
public interface Logger {
    public void writeLog();
}

// 数据库日志记录器：具体产品
class DatabaseLogger implements Logger {

    public void writeLog() {
        System.out.println("数据库日志记录器");
    }
}

// 文件日志记录器：具体产品
class FileLogger implements Logger {

    public void writeLog() {
        System.out.println("文件日志记录器");
    }
}

// 日志记录器工厂接口：抽象工厂
interface LoggerFactory {
    public Logger createLogger();
    // 引入重载
    public Logger createLogger(String args);
    public Logger createLogger(Object obj);
}

// 数据库日志记录器工厂类：具体工厂
class DatabaseLoggerFactory implements LoggerFactory {
    public Logger createLogger() {
        // 链接数据库，代码省略
        // 创建数据库日志记录器对象
        Logger logger = new DatabaseLogger();
        // 初始化数据库日志记录器，代码省略
        return logger;
    }

    public Logger createLogger(String args) {
        //使用参数args作为连接字符串来连接数据库，代码省略
        Logger logger = new DatabaseLogger();
        //初始化数据库日志记录器，代码省略
        return logger;
    }

    public Logger createLogger(Object obj) {
        //使用封装在参数obj中的连接字符串来连接数据库，代码省略
        Logger logger = new DatabaseLogger();
        //使用封装在参数obj中的数据来初始化数据库日志记录器，代码省略
        return logger;
    }
}

//文件日志记录器工厂类：具体工厂
class FileLoggerFactory implements LoggerFactory {
    public Logger createLogger() {
        //创建文件日志记录器对象
        Logger logger = new FileLogger();
        //创建文件，代码省略
        return logger;
    }

    public Logger createLogger(String args) {
        return null;
    }

    public Logger createLogger(Object obj) {
        return null;
    }
}

class Client {
    public static void main(String[] args) {
        LoggerFactory factory;
        Logger logger;
        factory = new FileLoggerFactory(); //可引入配置文件实现
        logger = factory.createLogger();
        logger.writeLog();
    }
}