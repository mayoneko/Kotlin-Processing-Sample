import processing.core.*
import processing.video.Capture

class hoge : PApplet(){
    lateinit var camera:Capture
    lateinit var pg:PGraphics

    override fun settings():Unit{
        size(640,480)
    }
    override fun setup():Unit{
        pg=createGraphics(width,height)
        camera=Capture(this,width,height)
        camera.start()
    }

    override fun draw() {
        pg.beginDraw()
        pg.fill(255)
        pg.noStroke()
        pg.ellipse(mouseX.toFloat(),mouseY.toFloat(),20.0f,20.0f)
        pg.endDraw()
        image(camera,0.0f,0.0f)
        image(pg,0.0f,0.0f)
    }

    override fun mousePressed() {
        pg.beginDraw()
        pg.clear()
        pg.endDraw()
    }

    fun captureEvent(camera:Capture){
        camera.read()
    }

    fun run(args:Array<String>):Unit=PApplet.main("hoge")
}

fun main(args: Array<String>) :Unit=hoge().run(args)

