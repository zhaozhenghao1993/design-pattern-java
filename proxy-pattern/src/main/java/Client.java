/**
 * 🙃
 * 🙃
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/06/23 22:19
 * Client.java
 */

// 身份验证类，业务类，它提供方法Validate()来实现身份验证
class AccessValidator {

    public boolean Validate(String userId) {
        System.out.println("在数据库中验证用户'" + userId + "'是否是合法用户？");
        if (userId.equals("杨过")) {
            System.out.println(userId + "登录成功！");
            return true;
        }
        else {
            System.out.println(userId + "登录失败！");
            return false;
        }
    }
}

// 日志记录类，业务类，它提供方法Log()来保存日志。
class Logger {

    //模拟实现日志记录
    public void Log(String userId) {
        System.out.println("更新数据库，用户" + userId + "查询次数加1!");
    }
}

// 抽象查询类，充当抽象主题角色，它声明了doSearch()方法。
interface Searcher {
    String doSearch(String userId, String keyword);
}

// 具体查询类，充当真实主题角色，它实现查询功能，doSearch()来查询信息。
class RealSearcher implements Searcher {

    public String doSearch(String userId, String keyword) {
        System.out.println("用户" + userId + "使用关键词" + keyword + "查询商务信息!");
        return "返回具体内容";
    }
}

// 代理查询类，充当代理主题角色，它是查询代理，维持了对RealSearcher对象、AccessValidator对象和Logger对象的引用。
class ProxySearcher implements Searcher {

    private RealSearcher realSearcher = new RealSearcher(); // 维持一个对真实主题的引用
    private AccessValidator validator;
    private Logger logger;

    public String doSearch(String userId, String keyword) {
        //如果身份验证成功，则执行查询
        if (this.Validate(userId)) {
            String result = realSearcher.doSearch(userId, keyword); //调用真实主题对象的查询方法
            this.Log(userId); //记录查询日志
            return result; //返回查询结果
        } else {
            return null;
        }
    }

    //创建访问验证对象并调用其Validate()方法实现身份验证
    public boolean Validate(String userId) {
        validator = new AccessValidator();
        return validator.Validate(userId);
    }

    //创建日志记录对象并调用其Log()方法实现日志记录
    public void Log(String userId) {
        logger = new Logger();
        logger.Log(userId);
    }
}

public class Client {

    public static void main(String[] args) {
        Searcher searcher;
        searcher = new ProxySearcher();

        String result = searcher.doSearch("杨过", "玉女心经");
    }
}

/**
 *      本实例是保护代理和智能引用代理的应用实例，在代理类ProxySearcher中实现对真实主题类的权限控制和引用计数，
 *  如果需要在访问真实主题时增加新的访问控制机制和新功能，只需增加一个新的代理类，再修改配置文件，
 *  在客户端代码中使用新增代理类即可，源代码无须修改，符合开闭原则。
 */
