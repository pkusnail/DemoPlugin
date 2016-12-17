package com.AlejandroSeaah;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
/**
 * Created by alejandroseaah on 16/12/17.
 */
public class Nationality extends DefaultPlugin {
    @Override
    public Output postProcess(Output output) {
        return super.postProcess(output);
    }

    @Override
    public Output Process(Input input) {
        //just for demo purpose, see the test case in https://github.com/pkusnail/Hot_Deployment_Plugin_Framework.git
        String json = input.getValue();
        JSONObject obj = JSON.parseObject(json);
        if (obj.containsKey("nationality")){
            if ( 2 == (Integer)obj.get("nationality") ){
                obj.put("nationality","中国");
            }
        }
        return new Output(input.getTopic(),obj.toString());
    }
}
