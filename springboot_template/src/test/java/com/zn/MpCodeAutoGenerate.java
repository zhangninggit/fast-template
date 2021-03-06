package com.zn;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;


/**
 * @author zhangning
 * @date 2021/8/31 10:36
 */
public class MpCodeAutoGenerate {

    // jdbcURL数据库连接
    private static final String JDBCURL = "jdbc:mysql://192.168.2.5:3306/vue-sms?useUnicode=true&characterEncoding=utf8&useSSL=false";
    // 配置数据库连接用户名
    private static final String USERNAME = "root";
    // 配置数据库连接密码
    private static final String PASSWORD = "123456";
    // 代码生成位置 (当前项目位置)
    private static final String PROJECT_PATH = "D:\\develop\\fast-template\\springboot_template";

    // 指定需要生成代码的表名
    private static final String TABLE = "t_user_info";

    //------------------------------------------------------------//

    @Test
    public void autoGenerate() {
        // Step1：代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // Step2：全局配置
        GlobalConfig gc = new GlobalConfig();
        // 填写代码生成的目录(需要修改)
        //String projectPath = "E:\\myProject\\test\\test_mybatis_plus";
       // String projectPath = "D:\\develop\\IdeaProjects\\fast-template-layui-crud\\springboot_template";

        // 拼接出代码最终输出的目录
        gc.setOutputDir(PROJECT_PATH + "/src/main/java");
        // 配置开发者信息（可选）（需要修改）
        gc.setAuthor("zhangning");
        // 配置是否打开目录，false 为不打开（可选）
        gc.setOpen(false);
        // 实体属性 Swagger2 注解，添加 Swagger 依赖，开启 Swagger2 模式（可选）
        gc.setSwagger2(true);
        // 重新生成文件时是否覆盖，false 表示不覆盖（可选）
        gc.setFileOverride(false);
        // 配置主键生成策略，此处为 ASSIGN_ID（可选）
        gc.setIdType(IdType.AUTO);
        // 配置日期类型，此处为 ONLY_DATE（可选）
        gc.setDateType(DateType.ONLY_DATE);
        // 默认生成的 service 会有 I 前缀
        // gc.setServiceName("%sService");
        mpg.setGlobalConfig(gc);

        // Step3：数据源配置（需要修改）
        DataSourceConfig dsc = new DataSourceConfig();
        // 配置数据库 url 地址
        // dsc.setUrl("jdbc:mysql://localhost:3306/testMyBatisPlus?useUnicode=true&characterEncoding=utf8");
        dsc.setUrl(JDBCURL);
        // dsc.setSchemaName("testMyBatisPlus"); // 可以直接在 url 中指定数据库名
        // 配置数据库驱动
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        // 配置数据库连接用户名
        dsc.setUsername(USERNAME);
        // 配置数据库连接密码
        dsc.setPassword(PASSWORD);
        mpg.setDataSource(dsc);

        // Step:4：包配置
        PackageConfig pc = new PackageConfig();
        // 配置父包名（需要修改）
        pc.setParent("com.zn");
        // 配置模块名（需要修改）
        pc.setModuleName("");
   /*     // 配置 entity 包名
        pc.setEntity("entity");
        // 配置 mapper 包名
        pc.setMapper("dao");
        // 配置 mapper xml文件 包名
        pc.setXml("dao.xml");
        // 配置 service 包名
        pc.setService("service");
        // 配置 controller 包名
        pc.setController("controller");*/


        // 配置 entity 包名
        pc.setEntity("entity");
        // 配置 mapper 包名
        pc.setMapper("dao");
        // 配置 mapper xml文件 包名
        pc.setXml("dao.xml");

        // 配置 service 包名
        pc.setService("service");
        // 配置 controller 包名
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        // Step5：策略配置（数据库表配置）
        StrategyConfig strategy = new StrategyConfig();

        // 指定表名（可以同时操作多个表，使用 , 隔开）（需要修改）
        strategy.setInclude(TABLE);

        // 配置数据表与实体类名之间映射的策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 生成Entuty的类名时去掉表前缀
        strategy.setTablePrefix("t_");
        // 配置数据表的字段与实体类的属性名之间映射的策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 配置 lombok 模式
        strategy.setEntityLombokModel(true);
        // 配置 rest 风格的控制器（@RestController）
        strategy.setRestControllerStyle(true);
        // 配置驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        // 配置表前缀，生成实体时去除表前缀
        // 此处的表名为 test_mybatis_plus_user，模块名为 test_mybatis_plus，去除前缀后剩下为 user。
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);

        // Step6：执行代码生成操作
        mpg.execute();
    }
}