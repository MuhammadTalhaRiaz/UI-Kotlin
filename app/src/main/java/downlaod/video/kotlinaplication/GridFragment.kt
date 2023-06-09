package downlaod.video.kotlinaplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import downlaod.video.kotlinaplication.Adapter.GridRVAdapter
import downlaod.video.kotlinaplication.Models.GridViewModal

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GridFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GridFragment : Fragment() {
    lateinit var courseGRV: GridView
    lateinit var courseList: List<GridViewModal>
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_grid, container, false)
        courseGRV = view.findViewById(R.id.idGRV)
        courseList = ArrayList<GridViewModal>()
        courseList = courseList + GridViewModal("Title", R.drawable.slide1)
        courseList = courseList + GridViewModal("Title", R.drawable.slide1)
        courseList = courseList + GridViewModal("Title", R.drawable.slide1)
        courseList = courseList + GridViewModal("Title", R.drawable.slide1)
        courseList = courseList + GridViewModal("Title", R.drawable.slide1)

        val courseAdapter = GridRVAdapter(courseList = courseList, requireContext())
        courseGRV.adapter = courseAdapter
        courseGRV.onItemClickListener = AdapterView.OnItemClickListener {
                _, _, position, _ ->
            // inside on click method we are simply displaying
            Toast.makeText(
                requireContext(), courseList[position].courseName + " selected",
                Toast.LENGTH_SHORT
            ).show()
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GridFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GridFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}