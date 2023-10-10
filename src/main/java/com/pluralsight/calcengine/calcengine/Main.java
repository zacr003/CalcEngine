package com.pluralsight.calcengine.calcengine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            performCalculations();
        } else if (args.length == 1 && args[0].equals("interactive")) {
            executeInteractively();
        } else if (args.length == 3)
            performOperation(args);
        else
            System.out.println("Please provide an operation code and 2 numeric values");
    }

    static void performCalculations() {
        //         Example of Parallel Arrays
//        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
//        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
//        char[] opCodes = {'d', 'a', 's', 'm'};
//        double[] results = new double[opCodes.length];

        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation(MathOperation.DIVIDE, 100.0d, 50.0d);
        equations[1] = new MathEquation(MathOperation.ADD, 25.0d, 92.0d);
        equations[2] = new MathEquation(MathOperation.SUBTRACT, 225.0d, 17.0d);
        equations[3] = new MathEquation(MathOperation.MULTIPLY, 11.0d, 3.0d);

//         equations[0].leftVal = 100.0d;
//         equations[0].rightVal = 50.0d;
//         equations[0].opCode = 'd';

//        for (int i = 0; i < opCodes.length; i++) {
//            results[i] = execute(opCodes[i], leftVals[i], rightVals[i]);
//        }
//        for (double currentResult : results)
//            System.out.println(currentResult);
        for(MathEquation equation : equations) {
            equation.execute();
            System.out.println(equation); // println will call toString()
        }

        System.out.println("Average result = " + MathEquation.getAverageResult());

//
        useOverloads();


    }

     static void useOverloads() {
        System.out.println();
        System.out.println("Using execute overloads");
        System.out.println();

        MathEquation equationOverlaod = new MathEquation(MathOperation.DIVIDE);
        double leftDouble = 9.0d;
        double rightDouble = 4.0d;

        equationOverlaod.execute(leftDouble, rightDouble);

        System.out.println("Overload result with doubles: " + equationOverlaod.getResult());


        int leftInt = 9;
        int rightInt = 4;
        equationOverlaod.execute(leftInt, rightInt);
        System.out.println("Overload result with ints: " + equationOverlaod.getResult());
    }

//    private static MathEquation create(double leftVal, double rightVal, char opCode) {
//        MathEquation equation = new MathEquation();
//        equation.setLeftVal(leftVal);
//        equation.setRightVal(rightVal);
//        equation.setOpCode(opCode);
//
//        return equation;
//    }

    static void executeInteractively() {
        System.out.println("Enter an operation and two numbers");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);
    }

    private static void performOperation(String[] parts) {
        MathOperation opCode = MathOperation.valueOf(parts[0].toUpperCase());
        double leftVal = valueFromWord(parts[1]);
        double rightVal = valueFromWord(parts[2]);
        MathEquation equation = new MathEquation(opCode, leftVal, rightVal);
        equation.execute();
        System.out.println(equation);
    }

//    private static void displayResult(char opCode, double leftVal, double rightVal, double result) {
//        char symbol = symbolFromOpCode(opCode);
//        StringBuilder builder = new StringBuilder(20);
//        builder.append(leftVal);
//        builder.append(" ");
//        builder.append(symbol);
//        builder.append(" ");
//        builder.append(rightVal);
//        builder.append(" = ");
//        builder.append(result);
//        String output = builder.toString();
//        System.out.println(output);
//    }

//    private static char symbolFromOpCode(char opCode) {
//        char[] opCodes = {'d', 'a', 's', 'm'};
//        char[] symbols = {'/', '+', '-', '*'};
//        char symbol = ' ';
//        for (int index = 0; index < opCodes.length; index++) {
//            if (opCode == opCodes[index]) {
//                symbol = symbols[index];
//                break;
//            }
//        }
//        return symbol;
//    }

//    private static void handleCommandLine(String[] args) {
//        char opCode = args[0].charAt(0);
//        double leftVal = Double.parseDouble(args[1]);
//        double rightVal = Double.parseDouble(args[2]);
//        double result = execute(opCode, leftVal, rightVal);
//        System.out.println(result);
//
//    }


//    static double execute(char opCode, double leftVal, double rightVal) {
//        double result;
//        switch (opCode) {
//            case 'a':
//                result = leftVal + rightVal;
//                break;
//            case 's':
//                result = leftVal - rightVal;
//                break;
//            case 'm':
//                result = leftVal * rightVal;
//                break;
//            case 'd':
//                result = rightVal != 0 ? leftVal / rightVal : 0.0d;
//                break;
//            default:
//                System.out.println("Invalid opCode: " + opCode);
//                result = 0.0d;
//                break;
//        }
//        return result;
//    }

//    static char opCodeFromString(String operationName) {
//        char opCode = operationName.charAt(0);
//        return opCode;
//    }

    static double valueFromWord(String word) {
        String[] numberWords = {
                "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        };
        boolean isValueSet = false;
        double value = 0d;
        for (int index = 0; index < numberWords.length; index++) {
            if (word.equals(numberWords[index])) {
                value = index;
                isValueSet = true;
                break;
            }
        }
        if(!isValueSet) {
            value = Double.parseDouble(word);
        }
        return value;
    }

    //Methods and parameters - 9/29/23
//    static void doSomething() {
//        System.out.println("Inside method");
//        System.out.println("Still Inside");
//    }
//
//    static void showSum(float x, float y, int count) {
//        float sum = x + y;
//        for (int i = 0; i < count; i++) {
//            System.out.println(sum);
//        }
//    }
//
//
//    static double calculateInterest(double amt, double rate, int years) {
//        return amt * rate * years;
//    }
//
//    static double[] produceInterestHistory(double amt, double rate, int years) {
//        double[] accumulatedInterest = new double[years];
//        for (int yearIndex = 0; yearIndex < years; yearIndex++) {
//            int year = yearIndex + 1;
//            accumulatedInterest[yearIndex] = calculateInterest(amt, rate, year);
//        }
//        return accumulatedInterest;
//    }

//    FlightCrewJob job1 = FlightCrewJob.PILOT;
//    FlightCrewJob job2 = FlightCrewJob.FLIGHT_ATTENDANT;
//
//    void displayJobResponsibilites(FlightCrewJob job) {
//        switch (job) {
//            case FLIGHT_ATTENDANT:
//                System.out.println("Assures passenger safety");
//            case COPILOT:
//                System.out.println("Assists in flying the plane");
//            case PILOT:
//                System.out.println("Flies the plane");
//
//        }
//    }

//    CrewMember geetha = new CrewMember((FlightCrewJob.PILOT "Geetha");
//    CrewMember bob = new CrewMember((FlightCrewJob.FLIGHT_ATTENDANT, "Bob");
//    whoIsInCharge(geetha, bob);
//
//    void whoIsInCharge(CrewMember member1, CrewMember member2) {
//        CrewMember theBoss = member1.getJob().compareTo(member2.getJob()) > 0 ?
//                member1 : member2;
//        System.out.println(theBoss.getName() + "is the boss");
//    }
}