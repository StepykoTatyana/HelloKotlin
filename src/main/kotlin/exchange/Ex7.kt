package exchange

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

fun main() {
    // Create a new BufferedImage instance with image size 256 X 256
    // The first parameter is the image waterMark.getWidth, while the second is the image waterMark.getHeight
    // The third parameter should be BufferedImage.TYPE_INT_ARGB for a 32-bit image
    // or BufferedImage.TYPE_INT_RGB for a 24-bit image
    val myImage: BufferedImage = BufferedImage(364, 256, BufferedImage.TYPE_INT_ARGB)

    for (i in 0 until myImage.width) {
        for (j in 0 until myImage.height) {
            myImage.setRGB(i, j, Color(0, 250, 0, j).rgb) // Green color with alpha channel value equal to j

//            // Get alpha value from Color instance
//            val c = Color(255, 0, 0, 127)  // Create a color instance, with alpha equal to 127
//            val alpha = c.alpha            // Get alpha channel value
//
//            // Create Color instance for pixel at (x, y) position, alpha channel is also set
//            val color = Color(myImage.getRGB(i, j), true)  // where bI is a BufferedImage instance
        }
    }


    val outputFile =
        File("C:\\IdeaProjects\\HelloKotlin\\src\\waterMark.main\\kotlin\\exchange\\alpha.png")         // Output the image
    ImageIO.write(myImage, "png", outputFile)  // Create an image using the BufferedImage


    val height: Int = 800
    val width: Int = 600
    val image = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
    val graphics = image.createGraphics()
    val graphics1 = image.createGraphics()
    val graphics2 = image.createGraphics()
    val graphicsNew = image.createGraphics()
    graphics.drawString("jhgjhg", 0, 0)
    graphics.drawLine(20, 50, 100, 104)
    graphics.drawString("Playing with images", 80, 80)

    graphics.color = Color.RED
    graphics.drawOval(50, 50, 100, 100)
//    graphics.drawString("Hello, images!", 50, 50)
    graphics.color = Color.YELLOW
    graphics.drawOval(50, 75, 100, 100)
//    graphics.drawString("Hello, images!", 51, 51)
    graphics.color = Color.GREEN
    graphics.drawOval(75, 50, 100, 100)
//    graphics.drawString("Hello, images!", 52, 52)
    graphics.color = Color.BLUE
    graphics.drawOval(75, 75, 100, 100)

    graphics.dispose()


    graphics.drawArc(200, 200, 100, 250, 45, 90)
//    graphics.color = Color.YELLOW
    graphics.drawPolygon(intArrayOf(10, 20, 30), intArrayOf(100, 20, 100), 3)
    graphics.drawPolygon(
        intArrayOf(50, 100, 200, 250, 200, 100),
        intArrayOf(150, 250, 250, 150, 50, 50), 6
    )
    val imageFile = File("C:\\IdeaProjects\\HelloKotlin\\src\\waterMark.main\\kotlin\\exchange\\myFirstImage.png")

    saveImage(image, imageFile)


    val image2: BufferedImage = ImageIO.read(imageFile)

}

fun saveImage(image: BufferedImage, imageFile: File) {
    ImageIO.write(image, "png", imageFile)

}