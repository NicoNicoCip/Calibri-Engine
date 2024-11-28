package io.github.pws.calibri.engine.core;

public class FramerateController {
    public int targetFramerate = -1;
    public long lastFrameTime;
    public double deltaTime;
    public boolean vsyncEnabled = false;
    public int refreshRate = 60;

    public FramerateController() {
        lastFrameTime = System.nanoTime();
        deltaTime = 0.0;
    }

    /**
     * Set the target framerate (FPS).
     * @param targetFramerate Desired framerate. Use -1 for unlimited.
     */
    public void setTargetFramerate(int targetFramerate) {
        this.targetFramerate = targetFramerate;
    }

    /**
     * Enable or disable VSync simulation.
     * @param enabled True to enable, false to disable.
     * @param refreshRate Display refresh rate (in Hz). Default is 60 Hz.
     */
    public void setVSync(boolean enabled, int refreshRate) {
        this.vsyncEnabled = enabled;
        this.refreshRate = refreshRate;
    }

    /**
     * Call this at the end of each frame to regulate the framerate.
     * Calculates deltaTime for the frame.
     */
    public void regulateFramerate() {
        long currentTime = System.nanoTime();
        long frameDuration = currentTime - lastFrameTime;

        // Calculate deltaTime in seconds
        deltaTime = frameDuration / 1_000_000_000.0;

        // Determine target frame duration (in nanoseconds)
        long targetDuration;
        if (vsyncEnabled) {
            targetDuration = 1_000_000_000L / refreshRate; // VSync duration
        } else if (targetFramerate > 0) {
            targetDuration = 1_000_000_000L / targetFramerate; // Target FPS duration
        } else {
            targetDuration = 0; // No limit
        }

        if (frameDuration < targetDuration) {
            // Sleep to maintain the desired framerate
            long sleepTime = (targetDuration - frameDuration) / 1_000_000L; // Convert to milliseconds
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Include sleep time in deltaTime
            long sleepNano = targetDuration - frameDuration;
            deltaTime = (frameDuration + sleepNano) / 1_000_000_000.0;
        }

        lastFrameTime = System.nanoTime(); // Reset the timer for the next frame
    }



    public class FPSCounter
    {
        private static int frameCount = 0;
        private static int currentFrameCount = 0;
        private static long lastFPSCheck = System.nanoTime();

        public static void countFrame()
        {
            frameCount++;

            if (System.nanoTime() - lastFPSCheck >= 1_000_000_000)
            {
                currentFrameCount = frameCount;
                frameCount = 0;
                lastFPSCheck = System.nanoTime();
            }
        }

        public static int getCurrentFrameCount()
        {
            return currentFrameCount;
        }
    }
}


