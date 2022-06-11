package go.faddy.hmrsystem.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import go.faddy.hmrsystem.R
import go.faddy.hmrsystem.databinding.ItemViewCustomerBalanceBinding
import go.faddy.hmrsystem.models.CustomerBalanceModel

class FacadeCustomerBalanceAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dataList: MutableList<CustomerBalanceModel> = mutableListOf()
    var closeTab: ((index: Int) -> Unit)? = null
    var onTabSelect: ((index: Int, theTabTitle: String) -> Unit)? = null
    var sizeInvoiceNumber = 0
    var sizeDocType = 0
    var sizeBalance = 0
    var sizeInvDate = 0
    var sizeDebit = 0
    var sizeCredit = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: ItemViewCustomerBalanceBinding = ItemViewCustomerBalanceBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            val model = dataList[position]
            val binding = holder.binding
            if (position % 2 == 0) binding.theConslayout.setBackgroundResource(R.drawable.background_light_red)
            else binding.theConslayout.setBackgroundResource(R.drawable.background_light_green)
            calcSize(binding)
            if (position == 0) {
                binding.invoiceNumber.text = "Invoice Number"
                binding.documentType.text = "Document Type"
                binding.debit.text = "Debit"
                binding.credit.text = "Credit"
                binding.balance.text = "Balance"
                binding.invoiceDate.text = "Invoice Date"

            } else {

                binding.invoiceNumber.text = model.invnum
                binding.documentType.text = model.doctype
                binding.debit.text = model.debit.toString()
                binding.credit.text = model.credit.toString()
                binding.balance.text = (model.debit - model.credit).toString()
                binding.invoiceDate.text = model.invdate

            }

        }
    }

    private fun calcSize(binding: ItemViewCustomerBalanceBinding) {
        if (binding.invoiceNumber.width > sizeInvoiceNumber) {
            sizeInvoiceNumber = binding.invoiceNumber.width

        } else binding.invoiceNumber.width = sizeInvoiceNumber
        if (binding.documentType.width > sizeDocType) {

            sizeDocType = binding.documentType.width
        } else binding.documentType.width = sizeDocType
        if (binding.debit.width > sizeDebit) {

            sizeDebit = binding.debit.width
        } else binding.debit.width = sizeDebit
        if (binding.credit.width > sizeCredit) {

            sizeCredit = binding.credit.width
        } else binding.credit.width = sizeInvoiceNumber
        if (binding.balance.width > sizeBalance) {

            sizeBalance = binding.balance.width
        } else binding.balance.width = sizeBalance
        if (binding.invoiceDate.width > sizeInvDate) {

            sizeInvDate = binding.invoiceDate.width
        } else binding.invoiceDate.width = sizeInvDate
    }

    internal inner class ViewHolder(val binding: ItemViewCustomerBalanceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {

        }
    }

    fun initLoad(list: List<CustomerBalanceModel>) {
        dataList.clear()
        dataList.addAll(list)
        notifyDataSetChanged()
    }


}