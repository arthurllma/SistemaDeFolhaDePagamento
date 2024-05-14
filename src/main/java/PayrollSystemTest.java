public class PayrollSystemTest {

  public static void main(String[] args) {

    // cria objetos de subclasse
    SalariedEmployee salariedEmployee = new SalariedEmployee("Arthur", "Lima", "191-17-1000", 3500.00);
    HourlyEmployee hourlyEmployee = new HourlyEmployee("Isabel", "Lima", "121-22-2345", 30.75, 40);
    CommissionEmployee commissionEmployee = new CommissionEmployee("Guilherme", "Sampaio", "333-33-3333", 10000, .08);
    BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Jonas", "Sampaio",
        "444-44-4444", 5000, .06, 1200);

    System.out.println("Funcionários processados individualmente:");
    System.out.println();
    System.out.printf("%s%n%s: R$%,.2f%n%n", salariedEmployee, "salário auferido", salariedEmployee.earnings());
    System.out.printf("%s%n%s: R$%,.2f%n%n", hourlyEmployee, "salário auferido", hourlyEmployee.earnings());
    System.out.printf("%s%n%s: R$%,.2f%n%n", commissionEmployee, "salário auferido", commissionEmployee.earnings());
    System.out.printf("%s%n%s: R$%,.2f%n%n", basePlusCommissionEmployee, "salário auferido",
        basePlusCommissionEmployee.earnings());

    // cria um array Employee de quatro elementos
    Employee[] employees = new Employee[4];
    // inicializa o array com Employees
    employees[0] = salariedEmployee;
    employees[1] = hourlyEmployee;
    employees[2] = commissionEmployee;
    employees[3] = basePlusCommissionEmployee;

    System.out.printf("Funcionários processados polimorficamente:%n%n");

    // processa genericamente cada elemento no employees
    for (Employee currentEmployee : employees) {

      System.out.println(currentEmployee); // invoca toString

      /* determina se elemento é um BasePlusCommissionEmployee */
      if (currentEmployee instanceof BasePlusCommissionEmployee) {
        // downcast da referência de Employee para
        // referência a BasePlusCommissionEmployee
        BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;

        employee.setBaseSalary(1.10 * employee.getBaseSalary());
        System.out.printf("Novo salário base com aumento de 10%% é: R$%,.2f%n", employee.getBaseSalary());
      } // fim do if
      System.out.printf("salário auferido: R$%,.2f%n%n", currentEmployee.earnings());
    } // for final
    System.out.println("-----------------------------------------------------");
    System.out.println();
    
/****** obtém o nome do tipo de cada objeto no array employees e para cada iteração(if/else), o tipo de cada funcionário é obtido ********/
    for (int j = 0; j < employees.length; j++) {
        String tipoFuncionario = "";
        if (employees[j] instanceof SalariedEmployee) {
            tipoFuncionario = "Funcionário Assalariado";
        } else if (employees[j] instanceof HourlyEmployee) {
            tipoFuncionario = "Funcionário Horista";
        } else if (employees[j] instanceof BasePlusCommissionEmployee) {
            tipoFuncionario = "Funcionário Comissionado de salário-base";
        } else if (employees[j] instanceof CommissionEmployee) {
            tipoFuncionario = "Funcionário Comissionado";
        } else {
            tipoFuncionario = "Funcionário";
        }
        System.out.printf("Funcionário %d registrado como %s%n", j, tipoFuncionario);
    }
  } // fim de main
} // fim da classe de teste do Sistema de folha de Pagamento (Main)