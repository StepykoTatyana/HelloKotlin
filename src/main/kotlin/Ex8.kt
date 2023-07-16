import java.awt.image.BufferedImage
import java.io.File
import java.io.FileNotFoundException
import javax.imageio.ImageIO


val separator: String = File.separator
val workingDirectory: String = System.getProperty ("user.dir")
var transparency : String? = null
fun main(){
    println("Input the image filename:")
    val file = readln()
    try {
        val imageFile = File("${workingDirectory}${separator}$file")
        val image: BufferedImage = ImageIO.read(imageFile)
        transparency = if (image.transparency==1){
            "OPAQUE"
        } else{
            "TRANSLUCENT"
        }
        println("Image file: $file\n" +
                "Width: ${image.width}\n" +
                "Height: ${image.height}\n" +
                "Number of components: ${image.colorModel.numComponents}\n" +
                "Number of color components: ${image.colorModel.numColorComponents}\n" +
                "Bits per pixel: ${image.colorModel.pixelSize}\n" +
                "Transparency: $transparency")
    } catch (e:  Exception){
        println("The file $file doesn't exist.")
    }
}