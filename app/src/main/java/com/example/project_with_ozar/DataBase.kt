package com.example.project_with_ozar

import android.content.Context
import androidx.room.*
import kotlinx.coroutines.CoroutineScope

@Database(entities = [ToDo::class], version = 1)
abstract class DB : RoomDatabase() {
    abstract fun getMyDao(): TodoDao

    companion object {
        @Volatile
        private var INSTANCE: DB? = null

        fun getInstance(context: Context): DB {
            if (INSTANCE != null) return INSTANCE!!
            synchronized(this) {
                INSTANCE = Room.databaseBuilder(context,DB::class.java,"dodoshka")
                    .build()
                return INSTANCE!!
            }

        }
    }
}
@Entity(tableName = "todo_model")
data class ToDo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String?,
    //val time: Int,
    val priority: String
)

@Dao
interface TodoDao {
    @Insert
    suspend fun insertTodo(todo: ToDo)

    @Delete
    suspend fun deleteTodo(todo: ToDo)


    @Query("SELECT * FROM todo_model")
    fun getTodos(): List<ToDo>


}



