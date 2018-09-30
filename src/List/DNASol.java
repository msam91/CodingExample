package List;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

class DNASol {
    
    public static void main(String args[]){
        DNASol dna = new DNASol();
         dna.findRepeatedDnaSequences("CAAAAAAAAAC");
    }
    
    public List<String> findRepeatedDnaSequences(String s) {
        
        Map<String,Integer>map = new HashMap<String,Integer>();
        List<String> result = new ArrayList<String>();
        if(s!=null && (s.isEmpty() || s.length() <=10)){
            return result;
        }
        
        for(int i=0;i+10<s.length();i++){            
            String sub = s.substring(i,i+10);
            if(map.containsKey(sub)){
                map.put(sub, map.get(sub)+1);
            }
            else{
                map.put(sub,1);
            }           
        }
      
        for(String key : map.keySet()){ 
            if(map.size()==1){
                result.add(key);
                break;
            }
            if(map.get(key)>1){
                result.add(key);
                
         
            }
        }
        
    return result;    
        
    }
}
