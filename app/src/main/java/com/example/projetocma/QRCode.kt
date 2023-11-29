package com.example.projetocma
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.zxing.Result
import com.google.zxing.ResultPoint
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.BarcodeResult
import com.journeyapps.barcodescanner.BarcodeView
import com.journeyapps.barcodescanner.DecoratedBarcodeView

class QRCode : AppCompatActivity() {
    //qrcode para este
    private val targetURL = "https://qrco.de/beb0YR"

    private lateinit var barcodeView: BarcodeView
    private val MY_PERMISSIONS_CAMERA = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrcode) // Substitua pelo seu layout XML


        barcodeView = findViewById(R.id.barcode_scanner)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                MY_PERMISSIONS_CAMERA
            )
        } else {
            startScanning()
        }
    }

    private fun startScanning() {
        barcodeView.decodeContinuous(object : BarcodeCallback {
            override fun barcodeResult(result: BarcodeResult?) {
                result?.let {
                    // Verifica se o texto do QR code é o URL desejado
                    if (it.text == targetURL) {
                        // Se for o URL desejado, direcione para a próxima página
                        val intent = Intent(this@QRCode, MuseusExplore::class.java)
                        startActivity(intent)
                    } else {
                        // Se não for o URL desejado, mostra uma mensagem ou realiza outra ação
                        Toast.makeText(
                            this@QRCode,
                            "QR code escaneado não corresponde ao URL desejado.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    // Se necessário, pare o escaneamento após encontrar um código
                    // barcodeView.pause()
                }
            }

            override fun possibleResultPoints(resultPoints: MutableList<ResultPoint>?) {
                // Se necessário, lógica para pontos de resultado possíveis
            }
        })
    }


    override fun onResume() {
        super.onResume()
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            == PackageManager.PERMISSION_GRANTED
        ) {
            barcodeView.resume()
        }
    }

    override fun onPause() {
        super.onPause()
        barcodeView.pause()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == MY_PERMISSIONS_CAMERA) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startScanning()
            } else {
                Toast.makeText(
                    this,
                    "Permissão de câmera negada. Não é possível escanear.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
