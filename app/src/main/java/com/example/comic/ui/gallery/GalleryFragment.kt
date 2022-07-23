package com.example.comic.ui.gallery

import android.graphics.Bitmap
import android.os.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.comic.R
import com.example.comic.databinding.FragmentGalleryBinding
import com.example.comic.service.impl.ImageServiceImpl
import java.util.concurrent.Executors

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel
    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var svc : ImageServiceImpl = ImageServiceImpl()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
                ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        binding.imageView.setOnClickListener{
//            nextImage(binding.imageView)
//        }
        //DownloadImageFromInternet(binding.imageView).execute()
        // Only for Background process (can take time depending on the Internet speed)
        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        executor.execute {

            try {
                var image: Bitmap? = svc.loadImg()
                // Tries to get the image and post it in the ImageView
                // with the help of Handler
                handler.post {
                    binding.imageView.setImageBitmap(image)
                }
            }catch (e: Exception) {
                e.printStackTrace()
            }
        }

        return root
    }


//    @Suppress("DEPRECATION")
//    private inner class DownloadImageFromInternet(var imageView: ImageView) : AsyncTask<String, Void, Bitmap?>() {
//
//        override fun doInBackground(vararg urls: String): Bitmap? {
//
//            return svc.loadImg()
//        }
//        override fun onPostExecute(result: Bitmap?) {
//
//            imageView.setImageBitmap(result)
//        }
//    }

//    @Suppress("DEPRECATION")
//    private inner class nextImage(var imageView: ImageView) : AsyncTask<String, Void, Bitmap?>() {
//
//        override fun doInBackground(vararg urls: String): Bitmap? {
//
//            return svc.loadImg("https://i2.manhuadb.com/ccbaike/1093/10936/13_eiqnpgek.jpg")
//        }
//        override fun onPostExecute(result: Bitmap?) {
//
//            imageView.setImageBitmap(result)
//        }
//    }

    private fun initImg(binding: FragmentGalleryBinding){
        initImg(binding, R.drawable.mayuyu)
    }
    private fun initImg(binding: FragmentGalleryBinding, resId: Int ){
        val img : ImageView = binding.imageView
        img.setImageResource(resId)
    }
    private fun initImg(binding: FragmentGalleryBinding, bitMap: Bitmap ){
        val img : ImageView = binding.imageView
        img.setImageBitmap(bitMap)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}