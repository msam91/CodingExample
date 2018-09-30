package javaExample;

public class MVC {

    class Employee{
        private String employeeId;
        private String employeeName;
        
        public void setEmployeeId(String employeeId){
            this.employeeId=employeeId;
        }
        
        public String getEmployeeId(){
            return this.employeeId;
        }
        
        public void setEmployeeName(String employeeName){
            this.employeeName=employeeName;
        }
        
        public String getEmployeeName(){
           return  this.employeeName;
        }
    }
    
    class View{
        
        public void printEmployee(String eName, String eId){
            System.out.println(eName);
            System.out.println(eId);
            
        }
    }
    
    class Controller{
        
        private Employee model;
        private View view;
        
        public Controller(Employee e, View v){
            this.model=e;
            this.view=v;
        }
        
        public void setEmployeeId(String employeeId){
            model.setEmployeeId(employeeId);
        }
        
        public String getEmployeeId(){
          return  model.getEmployeeId();
        }
        
        public void setEmployeeName(String employeeName){
            model.setEmployeeName(employeeName);
        }
        
        public String getEmployeeName(){
           return  model.getEmployeeName();
        }
        
        public void updateView(){
            view.printEmployee(model.employeeName, model.employeeId);
        }
        
        
    }
    
    public void empDemo(){
        Employee emp = new Employee();
        emp.setEmployeeId("1");
        emp.setEmployeeName("Manas");
        
        View v = new View();  
        Controller c = new Controller(emp, v);
        c.updateView();
        c.setEmployeeName("Samant");
        c.updateView();
    }
    
    public static void main(String args[]){
        MVC mvc = new MVC();
        mvc.empDemo();
    }
}
