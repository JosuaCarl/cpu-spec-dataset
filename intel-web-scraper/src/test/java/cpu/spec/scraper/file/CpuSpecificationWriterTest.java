package cpu.spec.scraper.file;

import cpu.spec.scraper.CpuSpecificationModel;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CpuSpecificationWriterTest {

    @Test
    void testWriteCsvFile() throws IOException {
        System.out.println("Execution directory: " + System.getProperty("user.dir"));

        File targetDir = new File(Paths.get(System.getProperty("user.dir")).getParent().toString() + "/dataset/");
        assertTrue(targetDir.exists(), "directory exists '" + targetDir.getAbsolutePath() + "' exists");

        CpuSpecificationModel spec = new CpuSpecificationModel();
        spec.cpuName = "testName";
        spec.manufacturerName = "intel";
        spec.usageType = "test";
        CpuSpecificationWriter.writeCsvFile(List.of(spec), "../dataset/test.csv");

        File outputFile = new File(Paths.get(System.getProperty("user.dir")).getParent().toString() + "/dataset/test.csv");
        assertTrue(outputFile.exists(), "file exists '" + outputFile.getAbsolutePath() + "' exists");
    }

    @Test
    void testInvalidPath() {
        CpuSpecificationModel spec = new CpuSpecificationModel();
        assertThrows(IOException.class, () -> CpuSpecificationWriter.writeCsvFile(List.of(spec), "../dataset/"));
    }
}
