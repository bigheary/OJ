package com.xxd.huawei;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by Administrator on 2016/9/2 0002.
 */
public class ErrorLog {

    public static void main(String[] args) throws IOException{
        FileInputStream fis=new FileInputStream("errlog");
        System.setIn(fis);
        Scanner in = new Scanner(System.in);
        String key = null;
        StringBuffer stringBuffer = new StringBuffer();
        String fileFulName = null;
        int splitIndex;
        int lineNumber;
        HashMap<String, ErrLog> map = new HashMap<>();
        while(in.hasNext()){
            fileFulName = in.next();//文件名中不能包含空格
            splitIndex = fileFulName.lastIndexOf("\\");
            lineNumber = in.nextInt();
            key = stringBuffer.append(fileFulName.substring(splitIndex+1))
                    .append(" ").append(String.valueOf(lineNumber)).toString();
            stringBuffer.setLength(0);
            ErrLog value = map.get(key);
            if (value == null){
                map.put(key, new ErrLog(key, 1));
            }else{
                value.cnt++;
            }
        }
        in.close();
        ArrayList<ErrLog> list = new ArrayList<>(map.values());//这里
        Comparator<ErrLog> cmp = new Comparator<ErrLog>() {
            @Override
            public int compare(ErrLog o1, ErrLog o2) {
                //升序、降序排序
                return o1.cnt == o2.cnt ? (o1.thisCnt - o2.thisCnt) : (o2.cnt - o1.cnt);
            }
        };
        Collections.sort(list, cmp);
        //最多展示8条记录
        int len = list.size() > 8 ? 8 : list.size();
        int lastIndex;
        for (int i = 0; i < len; i++){
            ErrLog tmpLog = list.get(i);
            lastIndex = tmpLog.key.lastIndexOf(" ");
            lastIndex = lastIndex > 16 ? lastIndex-16 : 0;
            System.out.println(tmpLog.key.substring(lastIndex)+
            " "+ tmpLog.cnt);
        }
    }

    static class ErrLog{
        private static int seqCnt;//出现的先后顺序
        int thisCnt;
        int cnt;//错误出现的次数
        private String key;

        ErrLog(String key, int cnt){
            this.key = key;
            this.cnt = cnt;
            thisCnt = seqCnt++;
        }

    }

}
