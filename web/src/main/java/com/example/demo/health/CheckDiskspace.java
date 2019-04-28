package com.example.demo.health;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;

@Health
@ApplicationScoped
public class CheckDiskspace implements HealthCheck {
    @Inject
    @ConfigProperty(name = "health.pathToMonitor")
    String pathToMonitor;
    @Inject
    @ConfigProperty(name = "health.freeSpaceThreshold")
    long freeSpaceThreshold;

    @Override
    public HealthCheckResponse call() {
        HealthCheckResponseBuilder builder = HealthCheckResponse.named("diskspace");
        checkDiskspace(builder);
        return builder.build();
    }

    private void checkDiskspace(HealthCheckResponseBuilder builder) {
        File root = new File(pathToMonitor);
        long usableSpace = root.getUsableSpace();
        long freeSpace = root.getFreeSpace();
        builder.withData("usableSpace", usableSpace)
                .withData("freeSpace", freeSpace)
                .state(freeSpace >= freeSpaceThreshold);
    }
}