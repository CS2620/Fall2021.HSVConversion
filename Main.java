import java.awt.Color;

class Main {
    public static void main(String[] args) {
        int r = 0;
        int g = 128;
        int b = 255;

        float[] hsv = new float[3];
        float[] hsv2 = new float[3];

        Color.RGBtoHSB(r, g, b, hsv);

        myConversion(r, g, b, hsv2);

        System.out.println(hsv[0] + " " + hsv[1] + " " + hsv[2]);
        System.out.println(hsv2[0] + " " + hsv2[1] + " " + hsv2[2]);
    }

    private static void myConversion(int r, int g, int b, float[] hsv) {
        float hue = -1;
        float saturation = -1;
        float value = -1;

        float red = (float) (r / 255.0);
        float green = (float) (g / 255.0);
        float blue = (float) (b / 255.0);

        float cMax = Math.max(Math.max(red, green), blue);
        value = cMax;
        float cMin = Math.min(Math.min(red, green), blue);
        float delta = cMax - cMin;

        if (cMax == 0) {
            hue = 0;
            value = 0;
            saturation = 0;
        } else {
            if (delta == 0) {
                hue = 0;
                saturation = (cMax - cMin) / cMax;

            } else {

                saturation = (cMax - cMin) / cMax;

                if (cMax == red)
                    hue = (60 * (green - blue) / delta + 0) % 360;
                else if (cMax == green)
                    hue = (60 * (blue - red) / delta + 120) % 360;
                else if (cMax == blue)
                    hue = (60 * (red - green) / delta + 240) % 360;

                hue /= 360;
            }
        }

        // Stuff

        hsv[0] = hue;
        hsv[1] = saturation;
        hsv[2] = value;

    }
}
