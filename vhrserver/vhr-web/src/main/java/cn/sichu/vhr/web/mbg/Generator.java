package cn.sichu.vhr.web.mbg;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * MBG生成器
 * 
 * @author sichu
 * @date 2022/05/11
 */
public class Generator {
    public static void main(String[] args) throws Exception {
        // MBG 执行过程中的 warnings
        List<String> warnings = new ArrayList<String>();

        // overwrite
        boolean overwrite = true;

        // 读取 MBG 配置文件
        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);

        // 创建 MBG
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);

        // 执行 generate
        myBatisGenerator.generate(null);

        // 输出警告
        for (int i = 0; i < warnings.size(); i++) {
            String warning = warnings.get(i);
            System.out.println(warning);
        }
    }
}
