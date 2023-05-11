package misc;

import java.util.ArrayList;

public class Call_center {
	
	private static class emp{
		
		private String level;
		private  boolean can_call;
		
		public emp(String lvl,boolean can) {
			level = lvl;
			can_call = can;
		}
		
		public void set_can(boolean can){
			can_call =  can;
		}
		
		public String get_level() {
			return level;
		}
		public boolean get_can(){
			return can_call;
		}
	}
	
	private static ArrayList<emp> all;
    
	private static ArrayList<emp> respondent_list;
	private static ArrayList<emp> manager_list;
	private static ArrayList<emp> director_list;
	
	
	public void add_emp(String lvl){
		
		emp e = new emp(lvl,true);
		all.add(e);
		if(e.get_level().equals("respondent")){
			respondent_list.add(e);
		}
		if(e.get_level().equals("manager")){
			manager_list.add(e);
		}
		if(e.get_level().equals("director")){
			director_list.add(e);
		}
	}
	
	public void change_can(emp e,boolean can){
		e.set_can(can);
	}
	
	public ArrayList<emp> get_all() {
		return all;
	}
	
	//dispatch call
	
	public emp get_first() {
		emp f = null;
		for(int i = 0;i < manager_list.size();i++){
			if(manager_list.get(i).get_can() == true) {
				f = manager_list.get(i);
			}
		}
		if(f != null) {
			return f;
		}
		else {
			for(int i = 0;i < director_list.size();i++) {
				if(director_list.get(i).get_can() == true) {
					f = director_list.get(i);
				}
			}
		}
		return f;
	}
	
	public emp dispatchCall(emp strt){
		
		if(strt.get_can() == true) {
			return strt;
		}
		else {
			return get_first();
		}
		
	}
	
}
