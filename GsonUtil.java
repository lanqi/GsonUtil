package util;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class GsonUtil {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList JsonArray2JavaList(String result,Class tClass){
        Gson gson = new Gson();
        //����֪ʶ������ArrayList
        ArrayList list = new ArrayList();
        //����һ��JsonElementԪ�� ��result��Stringת����JsonElement
        JsonElement el = new JsonParser().parse(result);
        //�½�JsonArray
        JsonArray jsonArray = null;
        //�ж��Ƿ���һ��JsonArray
        if(el.isJsonArray()){
            //����� ����ת����JsonArray
            jsonArray = el.getAsJsonArray();
        }
        //�½�һ�������� ��ȡJsonArray�ĵ���
        Iterator it = jsonArray.iterator();
        //�ж�jsonArray����û����һ��Ԫ��
        while(it.hasNext()){
            //�������ȡ��Ԫ��
            JsonElement e = (JsonElement) it.next();
            //����Ԫ�ش�JSONת����bean����
			Object oValue = gson.fromJson(e,tClass);
            //����bean��������ArrayList����ȥ
            list.add(oValue);
        }
        return list;
    }
	
	public static String Java2Json(Object obj){
        Gson gson = new Gson();
        String result = gson.toJson(obj);
        return result;
    }
	@SuppressWarnings({ "rawtypes" })
    public static String JavaList2Json(ArrayList list){
        Gson gson = new Gson();
        String result = gson.toJson(list);
        return result;
    }
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public static Object Json2Java(String result, Class tClass){
        Gson gson = new Gson();
        return gson.fromJson(result,tClass);
    }
}
