package com.terriconvalleyhackathon.wooppaytips.presentation.fragment

import android.Manifest.permission
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.terriconvalleyhackathon.wooppaytips.databinding.FragmentMyQrBinding
import com.terriconvalleyhackathon.wooppaytips.presentation.contract.MyQrFragmentContract
import com.terriconvalleyhackathon.wooppaytips.utils.PdfGenerator
import java.io.File
import java.net.URLConnection


class MyQrFragment : Fragment(), MyQrFragmentContract.View {
    private var _binding: FragmentMyQrBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMyQrBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeListeners()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun initializePresenter() {
        TODO("Not yet implemented")
    }

    override fun initializeViews() {
        TODO("Not yet implemented")
    }

    override fun initializeListeners() {
        binding.getQrButton.setOnClickListener {
            var pdfGenerator = PdfGenerator((binding.yourQrImageView.drawable as BitmapDrawable).bitmap)
            // below code is used for
            // checking our permissions.
            if (pdfGenerator.checkPermission(context)) {
                Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
//                pdfGenerator.requestPermission(activity)

                // requesting permissions if not provided.
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(permission.WRITE_EXTERNAL_STORAGE, permission.READ_EXTERNAL_STORAGE),
                    PdfGenerator.PERMISSION_REQUEST_CODE
                )

            }


            pdfGenerator.generatePDF(context)

            val fileDir = ContextWrapper(context).getDir("", Context.MODE_PRIVATE)
            val file: File = File(fileDir, "MyQR.pdf")

            val share = Intent()
            share.action = Intent.ACTION_SEND
            share.type = "application/pdf"
            share.putExtra(Intent.EXTRA_STREAM, file.path)
            startActivity(Intent.createChooser(share, "Share file"))


        }

    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        if (requestCode == PdfGenerator.PERMISSION_REQUEST_CODE) {
            if (grantResults.size > 0) {

                // after requesting permissions we are showing
                // users a toast message of permission granted.
                val writeStorage = grantResults[0] == PackageManager.PERMISSION_GRANTED
                val readStorage = grantResults[1] == PackageManager.PERMISSION_GRANTED
                if (writeStorage && readStorage) {
                    Toast.makeText(context, "Permission Granted..", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Permission Denied.", Toast.LENGTH_SHORT).show()
//                    finish()
                }
            }
        }
    }

}