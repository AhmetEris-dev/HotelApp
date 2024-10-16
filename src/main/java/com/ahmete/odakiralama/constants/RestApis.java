package com.ahmete.odakiralama.constants;

public class RestApis {
	private  static final String VERSION = "/v1";
	private  static final String API = "/api";
	private  static final String DEVELOPER = "/dev";
	private  static final String TEST = "/test";
	private  static final String PROD = "/prod";
	
	private  static final String ROOT = VERSION + DEVELOPER;
	
	public static final String MUSTERI = ROOT+"/musteri";
	public static final String ODA = ROOT+"/oda";
	public static final String KIRALAMA = ROOT+"/kiralama";
	public static final String ADD = "/add";
	public static final String FINDALL = "/find-all";
	public static final String FINDBYID = "/find-by-id";
	public static final String DOLU_ODALAR ="/gecmis-dolu-odalar";
	
	
}