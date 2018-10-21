//  Mybatis - paging 처리
package ex04;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {
    
    public static void main(String[] args) throws Exception {
        String resource = "ex04/mybatis-config-1.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
            new SqlSessionFactoryBuilder().build(inputStream);
        MemberDao memberDao = new MemberDao();
        memberDao.setSqlSessionFactory(sqlSessionFactory);
        
        // 페이징 처리
        int pageNo = 1;
        int pageSize = 3;
        
        HashMap<String, Object> params = new HashMap<>();
//        params.put("rowNo", 0);
//        params.put("pageSize", 3);
        /*  ((pageNo-1)*3)?
            
        */
        params.put("rowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        List<Member> list = memberDao.findAll(params);
        
        for (Member m : list) {
            System.out.printf("%d, %s, %s, %s \n",
                    m.getNo(), m.getName(), m.getEmail(), m.getTel());
        }
    }
}
