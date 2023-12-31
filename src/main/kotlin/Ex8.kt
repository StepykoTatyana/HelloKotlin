package watermark

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import java.util.*
import javax.imageio.ImageIO
import kotlin.math.abs


val separator: String = File.separator
var userAlphaChannel: String = "no"
val workingDirectory: String = System.getProperty("user.dir")
var transparency: String? = null
var nameOfWrong = "image"
var percentage: Int = -1
var width = 0
var height = 0
var widthX = 0
var heightY = 0

var listOfColorTransparency: MutableList<Int> = mutableListOf()

var flagWrong = false

fun main() {
    println("Input the image filename:")
    val file = readln()
    val image = checkFile(file)
    if (image != null) {
        println("Input the watermark image filename:")
        val fileWatermark = readln()


        nameOfWrong = "watermark"

        val imageWatermark = checkFile(fileWatermark)
        if (imageWatermark != null) {
            if (image.width < imageWatermark.width ||
                image.height <= imageWatermark.height
            ) {
                width = image.width - imageWatermark.width
                height = image.height - imageWatermark.height
                if (imageWatermark.transparency == 1) {
                    println("Do you want to set a waterMark.getTransparency color?")
                    if (readln() == "yes") {
                        println("Input a waterMark.getTransparency color ([Red] [Green] [Blue]):")
                        setTransparencyForImage()
                    } else {
                        transparency = "OPAQUE"
                    }
                } else {
                    transparency = "TRANSLUCENT"
                    println("Do you want to use the watermark's Alpha channel?")
                    userAlphaChannel = readln()
                }
                if (!flagWrong) {
                    checkPercentage()
                    if (percentage != -1) {
                        checkImageExtension(image, imageWatermark)
                    }
                }

            } else {
                println("The watermark's dimensions are larger.")
            }
        }

    }


}

fun checkImageExtension(image: BufferedImage, imageWatermark: BufferedImage) {
    println("Choose the position method (waterMark.single, grid):")
    when (readln()) {
        "waterMark.single" -> {
            single()
            outputFun(image, imageWatermark)
        }

        "grid" -> {
            outputFun(image, imageWatermark)
        }

        else -> {
            println("The position method input is invalid.")
        }

    }


}

fun single() {
    println("Input the watermark position ([x 0-$width] [y 0-$height]):")
    try {

        val listCoord = readln()
            .split(" ").stream().map { x -> x.toInt() }.toList()
        if (listCoord.size == 2) {
            if (listCoord[0] in 0..width
                && listCoord[1] in 0..height
            ) {
                widthX = listCoord[0]
                heightY = listCoord[1]

            } else {
                println("The position input is out of range.")
            }
        } else {
            println("The position input is invalid.")
        }
    } catch (e: java.lang.Exception) {
        println("The position input is invalid.")
    }


}

fun outputFun(image: BufferedImage, imageWatermark: BufferedImage) {
    println("Input the output image filename (jpg or png extension):")
    val imageOutput = readln()
    if (imageOutput.contains(".jpg") ||
        imageOutput.contains(".png")
    ) {

        val imageOutput1 = File("$workingDirectory$separator$imageOutput")
        val imageOutputBuff = BufferedImage(
            image.width, image.height,
            BufferedImage.TYPE_INT_RGB
        )

        for (x in widthX until image.width) {
            for (y in heightY until image.height) {

                val i = Color(image.getRGB(x, y))
                val w: Color = if (userAlphaChannel == "yes") {
                    Color(imageWatermark.getRGB(x, y), true)
                } else {
                    Color(imageWatermark.getRGB(x, y))
                }


                val color = if (w.alpha == 0) {
                    Color(i.red, i.green, i.blue)
                } else {
                    if (listOfColorTransparency.size == 3) {
                        if (w.red == listOfColorTransparency[0] && w.green == listOfColorTransparency[1] && w.blue == listOfColorTransparency[2]) {
                            Color(i.red, i.green, i.blue)
                        } else {
                            Color(
                                ((100 - percentage) * i.red + percentage * w.red) / 100,
                                ((100 - percentage) * i.green + percentage * w.green) / 100,
                                ((100 - percentage) * i.blue + percentage * w.blue) / 100
                            )
                        }

                    } else {
                        Color(
                            ((100 - percentage) * i.red + percentage * w.red) / 100,
                            ((100 - percentage) * i.green + percentage * w.green) / 100,
                            ((100 - percentage) * i.blue + percentage * w.blue) / 100
                        )
                    }
                }



                imageOutputBuff.setRGB(x, y, color.rgb)

            }
        }
        println("The watermarked image $imageOutput has been created.")
        ImageIO.write(imageOutputBuff, "png", imageOutput1)
    } else {
        println("The output file extension isn't \"jpg\" or \"png\".")
    }
}

fun checkPercentage() {
    println("dfsdf".compareTo("aAsfasf", true) == 1)
    println("Input the watermark waterMark.getTransparency waterMark.getPercentage (Integer 0-100):")
    val percentageUser = readln()
    try {
        if (percentageUser.toInt() in 0..100) {
            percentage = percentageUser.toInt()
        } else {
            println("The waterMark.getTransparency waterMark.getPercentage is out of range.")
        }
    } catch (e: java.lang.Exception) {
        println("The waterMark.getTransparency waterMark.getPercentage isn't an integer number.")
    }
}


fun checkFile(file: String): BufferedImage? {
    return try {
        val imageFile = File("$workingDirectory$separator$file")
        checkImage(ImageIO.read(imageFile))
    } catch (e: Exception) {
        println("The file $file doesn't exist.")
        null
    }

}

fun checkImage(image: BufferedImage): BufferedImage? {
    if (image.colorModel.numColorComponents == 3) {
        transparency = if (image.transparency == 1) {
            "OPAQUE"
        } else {
            "TRANSLUCENT"
        }
        if (image.colorModel.pixelSize in listOf(24, 32)) {
            return image
        } else {
            println("The $nameOfWrong isn't 24 or 32-bit.")
        }

    } else {
        println("The number of $nameOfWrong color components isn't 3.")
    }
    return null
}


fun setTransparencyForImage() {
    try {
        listOfColorTransparency = readln()
            .split(" ")
            .stream().map { x -> x.toInt() }.filter { x -> (x in 0..255) }.toList()
        if (listOfColorTransparency.size == 3) {
            transparency = "TRANSLUCENT"

        } else {
            flagWrong = true
            println("The waterMark.getTransparency color input is invalid.")
        }
    } catch (e: java.lang.Exception) {
        flagWrong = true
        println("The waterMark.getTransparency color input is invalid.")
    }
}