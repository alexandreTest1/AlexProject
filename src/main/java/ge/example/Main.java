package ge.example;
import java.util.*;
import java.util.stream.Collectors;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {


        List<TestResult> results = List.of(
                new TestResult("CreateApplication", 500, TestStatus.PASSED),       // სწრაფი, წარმატებული ტესტი
                new TestResult("CreateBorrower", 1500, TestStatus.FAILED),    // ნელი და ჩავარდნილი ტესტი
                new TestResult("CalculateOverdue", 800, TestStatus.PASSED),      // საშუალო სიჩქარის წარმატებული ტესტი
                new TestResult("GetCustomer", 2300, TestStatus.PASSED),   // ძალიან ნელი და წარმატებული ტესტი
                new TestResult("DisburseLoan", 2200, TestStatus.FAILED)    // ძალიან ნელი და ჩავარდნილი ტესტი
        );

        // შეიქმნა  ობიექტი, რომელიც იღებს ტესტების სიას

        TestResultAnalyzer analyzer = new TestResultAnalyzer(results);

        // ბეჭდავს საბოლოო რეპორტს
        analyzer.printReport();
    }
}



        // Enum, განსაზღვრავს ტესტის სტატუსს
enum TestStatus {
    PASSED,
    FAILED
}

// კლასი, რომელიც წარმოადგენს ერთ კონკრეტულ ტესტის შედეგს
class TestResult {
    private final String testName;    // ტესტის სახელი
    private final int durationMs;     // ტესტის შესრულების დრო მილიწამებში
    private final TestStatus status;  // ტესტის სტატუსი (PASSED / FAILED)

    // კონსტრუქტორი ტესტის შედეგისთვის
    public TestResult(String testName, int durationMs, TestStatus status) {
        this.testName = testName;
        this.durationMs = durationMs;
        this.status = status;
    }

    // გეთერი სახელისთვის
    public String getTestName() {
        return testName;
    }

    // გეთერი დროისთვის
    public int getDurationMs() {
        return durationMs;
    }

    // გეთერი სტატუსისთვის
    public TestStatus getStatus() {
        return status;
    }

    // toString მეთოდი, რომელიც აბრუნებს ტესტის დეტალებს წაკითხვად სტილში
    @Override
    public String toString() {
        return String.format("%s (%d ms, %s)", testName, durationMs, status);
    }
}

// კლასი ტესტების ანალიზისთვის
class TestResultAnalyzer {
    private final List<TestResult> results; // ტესტების სია

    // კონსტრუქტორი, რომელიც იღებს ტესტების სიას
    public TestResultAnalyzer(List<TestResult> results) {
        this.results = results;
    }

    //Total execution time - მეთოდი, რომელიც ითვლის ყველა ტესტის შესრულების დროის ჯამს
    public int getTotalExecutionTime() {
        return results.stream()
                .mapToInt(TestResult::getDurationMs) // ვიღებთ თითოეული ტესტის დრო მილიწამებში
                .sum();                             // ვაერთებთ ჯამში
    }

    //Average execution time - მეთოდი, რომელიც ითვლის საშუალო შესრულების დროს
    public double getAverageExecutionTime() {
        return results.stream()
                .mapToInt(TestResult::getDurationMs) // ვიღებთ დროებს
                .average()                           // ვთვლით საშუალოს
                .orElse(0.0);                        // თუ სია ცარიელია, ვაბრუნებთ 0
    }

    //Number of failed tests - მეთოდი, რომელიც ითვლის წარუმატებელი ტესტების რაოდენობას
    public long getFailedTestCount() {
        return results.stream()
                .filter(r -> r.getStatus() == TestStatus.FAILED) // ფილტრავს მხოლოდ FAILED სტატუსიანებს
                .count();                                        // ითვლის
    }

    // Bonus:
    //List of slow tests -  method getSlowTests- მეთოდი, რომელიც აბრუნებს ნელი ტესტების სიას (>1000 ms)
    public List<TestResult> getSlowTests() {
        return results.stream()
                .filter(r -> r.getDurationMs() > 1000)            // მხოლოდ ნელი ტესტები
                .sorted(Comparator.comparingInt(TestResult::getDurationMs).reversed()) // დალაგება ხანგრძლივობის მიხედვით უდიდესიოდან უმცირესამდე
                .collect(Collectors.toList());                     // მონაცემების ლისტად გარდაქმნა
    }


    //Sort tests by duration - მეთოდი, რომელიც აბრუნებს ყველა ტესტს დროის მიხედვით დახარისხებულს (მცირედან დიდამდე)
    public List<TestResult> getTestsSortedByDuration() {
        return results.stream()
                .sorted(Comparator.comparingInt(TestResult::getDurationMs))
                .collect(Collectors.toList());
    }

    //Print only failed test names -  მეთოდი, რომელიც აბრუნებს წარუმატებელი ტესტების სახელებს
    public List<String> getFailedTestNames() {
        return results.stream()
                .filter(r -> r.getStatus() == TestStatus.FAILED) // ჩავარდნილი ტესტების ფილტრი
                .map(TestResult::getTestName)                    // იღებს სახელს
                .collect(Collectors.toList());                   // მონაცემების ლისტად გარდაქმნა
    }



    // ბეჭდავს სრულ ანგარიშს ტესტების შესახებ
    public void printReport() {
        System.out.println("=== Test Execution Report ===");

       // System.out.println("Total tests: " + results.size());
        System.out.println("Total execution time: " + getTotalExecutionTime() + " ms");
        System.out.printf("Average execution time: %.2f ms%n", getAverageExecutionTime());
        System.out.println("Failed tests: " + getFailedTestCount());

        // დაბეჭდავს ჩავარდნილი ტესტების სახელებს
        System.out.println("\nFailed test names:");
        getFailedTestNames().forEach(name -> System.out.println(" - " + name));

        // ნელი ტესტები
        System.out.println("\nSlow tests (> 1000 ms):");
        getSlowTests().forEach(test -> System.out.println(" - " + test));

        // ყველა ტესტი დაჯგუფებულია დროის მიხედვით
        System.out.println("\nAll tests sorted by duration:");
        getTestsSortedByDuration().forEach(test -> System.out.println(" - " + test));

        System.out.println("=== End of Report ===");
    }
}
