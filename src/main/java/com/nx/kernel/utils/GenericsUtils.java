package com.nx.kernel.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
/**
 * 泛型工具類
 * @author lihuoming
 *
 */
public class GenericsUtils {
	/**  
     * 通過反射,獲得指定類的父類的泛型參數的實際類型. 如BuyerServiceBean extends DaoSupport<Buyer>  
     *  
     * @param clazz clazz 需要反射的類,該類必須繼承範型父類
     * @param index 泛型參數所在索引,從0開始.  
     * @return 範型參數的實際類型, 如果沒有實現ParameterizedType接口，即不支持泛型，所以直接返回<code>Object.class</code>
     */  
    @SuppressWarnings("unchecked")
	public static Class getSuperClassGenricType(Class clazz, int index) {    
        Type genType = clazz.getGenericSuperclass();//得到泛型父類  
        //如果沒有實現ParameterizedType接口，即不支持泛型，直接返回Object.class   
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;   
        }  
        //返回表示此類型實際類型參數的Type對象的數組,數組里放的都是對應類型的Class, 如BuyerServiceBean extends DaoSupport<Buyer,Contact>就返回Buyer和Contact類型   
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();                   
        if (index >= params.length || index < 0) { 
        	 throw new RuntimeException("你輸入的索引"+ (index<0 ? "不能小於0" : "超出了參數的總數"));
        }      
        if (!(params[index] instanceof Class)) {
            return Object.class;   
        }   
        return (Class) params[index];
    }
	/**  
     * 通過反射,獲得指定類的父類的第一個泛型參數的實際類型. 如BuyerServiceBean extends DaoSupport<Buyer>  
     *  
     * @param clazz clazz 需要反射的類,該類必須繼承泛型父類
     * @return 泛型參數的實際類型, 如果沒有實現ParameterizedType接口，即不支持泛型，所以直接返回<code>Object.class</code>
     */  
    @SuppressWarnings("unchecked")
	public static Class getSuperClassGenricType(Class clazz) {
    	return getSuperClassGenricType(clazz,0);
    }
	/**  
     * 通過反射,獲得方法返回值泛型參數的實際類型. 如: public Map<String, Buyer> getNames(){}
     *  
     * @param Method method 方法
     * @param int index 泛型參數所在索引,從0開始.
     * @return 泛型參數的實際類型, 如果沒有實現ParameterizedType接口，即不支持泛型，所以直接返回<code>Object.class</code>
     */ 
    @SuppressWarnings("unchecked")
	public static Class getMethodGenericReturnType(Method method, int index) {
    	Type returnType = method.getGenericReturnType();
    	if(returnType instanceof ParameterizedType){
    	    ParameterizedType type = (ParameterizedType) returnType;
    	    Type[] typeArguments = type.getActualTypeArguments();
            if (index >= typeArguments.length || index < 0) { 
            	 throw new RuntimeException("你輸入的索引"+ (index<0 ? "不能小於0" : "超出了參數的總數"));
            } 
    	    return (Class)typeArguments[index];
    	}
    	return Object.class;
    }
	/**  
     * 通過反射,獲得方法返回值第一個泛型參數的實際類型. 如: public Map<String, Buyer> getNames(){}
     *  
     * @param Method method 方法
     * @return 泛型參數的實際類型, 如果沒有實現ParameterizedType接口，即不支持泛型，所以直接返回<code>Object.class</code>
     */ 
    @SuppressWarnings("unchecked")
	public static Class getMethodGenericReturnType(Method method) {
    	return getMethodGenericReturnType(method, 0);
    }
    
	/**  
     * 通過反射,獲得方法輸入參數第index個輸入參數的所有泛型參數的實際類型. 如: public void add(Map<String, Buyer> maps, List<String> names){}
     *  
     * @param Method method 方法
     * @param int index 第幾個輸入參數
     * @return 輸入參數的泛型參數的實際類型集合, 如果沒有實現ParameterizedType接口，即不支持泛型，所以直接返回空集合
     */ 
    @SuppressWarnings("unchecked")
	public static List<Class> getMethodGenericParameterTypes(Method method, int index) {
    	List<Class> results = new ArrayList<Class>();
    	Type[] genericParameterTypes = method.getGenericParameterTypes();
    	if (index >= genericParameterTypes.length ||index < 0) {
             throw new RuntimeException("你輸入的索引"+ (index<0 ? "不能小於0" : "超出了參數的總數"));
        } 
    	Type genericParameterType = genericParameterTypes[index];
    	if(genericParameterType instanceof ParameterizedType){
    	     ParameterizedType aType = (ParameterizedType) genericParameterType;
    	     Type[] parameterArgTypes = aType.getActualTypeArguments();
    	     for(Type parameterArgType : parameterArgTypes){
    	         Class parameterArgClass = (Class) parameterArgType;
    	         results.add(parameterArgClass);
    	     }
    	     return results;
    	}
    	return results;
    }
	/**  
     * 通過反射,獲得方法輸入參數第一個輸入參數的所有泛型參數的實際類型. 如: public void add(Map<String, Buyer> maps, List<String> names){}
     *  
     * @param Method method 方法
     * @return 輸入參數的泛型參數的實際類型集合, 如果沒有實現ParameterizedType接口，即不支持泛型，所以直接返回空集合
     */ 
    @SuppressWarnings("unchecked")
	public static List<Class> getMethodGenericParameterTypes(Method method) {
    	return getMethodGenericParameterTypes(method, 0);
    }
	/**  
     * 通過反射,獲得Field泛型參數的實際類型. 如: public Map<String, Buyer> names;
     *  
     * @param Field field 字段
     * @param int index 泛型參數所在索引,從0開始.
     * @return 泛型參數的實際類型, 如果沒有實現ParameterizedType接口，即不支持泛型，所以直接返回<code>Object.class</code>
     */ 
    @SuppressWarnings("unchecked")
	public static Class getFieldGenericType(Field field, int index) {
    	Type genericFieldType = field.getGenericType();
    	
    	if(genericFieldType instanceof ParameterizedType){
    	    ParameterizedType aType = (ParameterizedType) genericFieldType;
    	    Type[] fieldArgTypes = aType.getActualTypeArguments();
    	    if (index >= fieldArgTypes.length || index < 0) { 
    	    	throw new RuntimeException("你輸入的索引"+ (index<0 ? "不能小於0" : "超出了參數的總數"));
            } 
    	    return (Class)fieldArgTypes[index];
    	}
    	return Object.class;
    }
	/**  
     * 通過反射,獲得Field泛型參數的實際類型. 如: public Map<String, Buyer> names;
     *  
     * @param Field field 字段
     * @param int index 泛型參數所在索引,從0開始.
     * @return 泛型參數的實際類型, 如果沒有實現ParameterizedType接口，即不支持泛型，所以直接返回<code>Object.class</code>
     */ 
    @SuppressWarnings("unchecked")
	public static Class getFieldGenericType(Field field) {
    	return getFieldGenericType(field, 0);
    }
}
