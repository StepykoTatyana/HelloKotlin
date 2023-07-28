package exchange

import java.io.File                   // Import the File class for file handling
import javax.imageio.ImageIO          // Import the ImageIO class for reading and writing images
import java.awt.image.BufferedImage   // BufferedImage Class
import java.awt.Color                 // Color class

fun main() {
    val inputFile = File("C:\\IdeaProjects\\HelloKotlin\\src\\waterMark.main\\kotlin\\exchange\\plane-in-sunset.jpg")  // Create a file instance in order to read the "24bit.png" image file

    // Create a BufferedImage instance from the 24-bit image file data
    val myImage: BufferedImage = ImageIO.read(inputFile)

    // myImage.waterMark.getWidth is the image waterMark.getWidth
    // myImage.waterMark.getHeight is the image waterMark.getHeight
    for (x in 0 until myImage.width) {               // For every column.
        for (y in 0 until myImage.height) {          // For every row
            val color = Color(myImage.getRGB(x, y))  // Read color from the (x, y) position

            val g = color.green              // Access the Green color value
            val b = color.blue               // Access the Blue color value
            // Use color.red in case the Red color is needed

            val colorNew = Color(255, g, b)  // Create a new Color instance with the red value equal to 255
            myImage.setRGB(x, y, colorNew.rgb)  // Set the new color at the (x, y) position
        }
    }
    val outputFileJpg = File("C:\\IdeaProjects\\HelloKotlin\\src\\waterMark.main\\kotlin\\exchange\\newImageFile.jpg")  // Output the file
    ImageIO.write(myImage, "jpg", outputFileJpg)  // Create an image using the BufferedImage instance data



    // Create a new BufferedImage instance with image size 256 X 256
    // The first parameter is the image waterMark.getWidth, while the second is the image waterMark.getHeight
    // The third parameter should be BufferedImage.TYPE_INT_ARGB for a 32-bit image
    // or BufferedImage.TYPE_INT_RGB for a 24-bit image
    val myImage2: BufferedImage = BufferedImage(256, 256, BufferedImage.TYPE_INT_ARGB)

    for (i in 0 until myImage2.width) {
        for (j in 0 until myImage2.height) {
            myImage2.setRGB(i, j, Color(0, 255, 0, j).rgb)  // Green color with alpha channel value equal to j
        }
    }
    val outputFile = File("C:\\IdeaProjects\\HelloKotlin\\src\\waterMark.main\\kotlin\\exchange\\alpha.png")         // Output the image
    ImageIO.write(myImage2, "png", outputFile)  // Create an image using the BufferedImage

}