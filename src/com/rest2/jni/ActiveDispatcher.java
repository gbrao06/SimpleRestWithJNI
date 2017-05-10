package com.rest2.jni;

//javah -jni -classpath "C:\Users\GETH COMMANDER\Documents\NetBeansProjects\JNI Test Project\build\classes" JNI.Main
//D:\Projects\java\workspace\TestJNIProject\bin>javah -jni test.jni.ActiveDispatcher
public class ActiveDispatcher {

	public int dummy;
	public String m_fullurl;
	public String m_dburl;
	public int m_dbport;
	
	public ActiveDispatcher(String dburl,int dbport){
		m_dburl=dburl;
		m_dbport=dbport;
	}
	
	public native int createRecords(String query);
	public native String getRecord(String tableName,String oid);
	public native String getAllRecords(String tableName);
	
	static{
		System.loadLibrary("TestDB");
	}
	
	public static void main(String[] args) {
		ActiveDispatcher main = new ActiveDispatcher("localhost.com",3306);
	   String ret=main.getRecord("testcollection","1000");
	    //System.out.println("hi my first programme");
	    //System.out.println("JNI GOT FROM C++="+ret);
	    
	}
	
		
}
