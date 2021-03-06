package label.dev.lifelinetimer.viewmodel.notesvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import label.dev.lifelinetimer.R
import label.dev.lifelinetimer.model.models.dbmodels.notes.ColorMarks
import label.dev.lifelinetimer.model.models.dbmodels.notes.NoteModel
import label.dev.lifelinetimer.model.repository.interfaces.Repository

class NoteRedactorViewModel(private val repository: Repository) : ViewModel() {

    fun updateTime(): String {
        return repository.getCurrentTime()
    }

    fun updateNote(note: NoteModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateNote(note)
        }
    }

    fun deleteNote(note: NoteModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteNote(note)
        }
    }

    fun findBackGround(color: String) = when (color) {
        ColorMarks.WHITE.name -> R.drawable.cm_white
        ColorMarks.BLUE.name -> R.drawable.cm_blue
        ColorMarks.GREEN.name -> R.drawable.cm_green
        ColorMarks.PURPLE.name -> R.drawable.cm_purple
        ColorMarks.RED.name -> R.drawable.cm_red
        ColorMarks.YELLOW.name -> R.drawable.cm_yellow
        else -> R.drawable.cm_white
    }
}