package com.example.todoproject.DataBase.Room;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TasksDao_Impl implements TasksDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Tasks> __insertionAdapterOfTasks;

  private final EntityDeletionOrUpdateAdapter<Tasks> __deletionAdapterOfTasks;

  private final EntityDeletionOrUpdateAdapter<Tasks> __updateAdapterOfTasks;

  public TasksDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTasks = new EntityInsertionAdapter<Tasks>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Tasks` (`id`,`taskName`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Tasks value) {
        stmt.bindLong(1, value.getId());
        if (value.getTaskName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTaskName());
        }
      }
    };
    this.__deletionAdapterOfTasks = new EntityDeletionOrUpdateAdapter<Tasks>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Tasks` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Tasks value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfTasks = new EntityDeletionOrUpdateAdapter<Tasks>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Tasks` SET `id` = ?,`taskName` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Tasks value) {
        stmt.bindLong(1, value.getId());
        if (value.getTaskName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTaskName());
        }
        stmt.bindLong(3, value.getId());
      }
    };
  }

  @Override
  public void insertTask(final Tasks tasks) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTasks.insert(tasks);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteTask(final Tasks tasks) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTasks.handle(tasks);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateTask(final Tasks tasks) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTasks.handle(tasks);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Tasks> getAll() {
    final String _sql = "SELECT * FROM tasks";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTaskName = CursorUtil.getColumnIndexOrThrow(_cursor, "taskName");
      final List<Tasks> _result = new ArrayList<Tasks>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Tasks _item;
        _item = new Tasks();
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpTaskName;
        _tmpTaskName = _cursor.getString(_cursorIndexOfTaskName);
        _item.setTaskName(_tmpTaskName);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Tasks getById(final long id) {
    final String _sql = "SELECT * FROM tasks WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTaskName = CursorUtil.getColumnIndexOrThrow(_cursor, "taskName");
      final Tasks _result;
      if(_cursor.moveToFirst()) {
        _result = new Tasks();
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpTaskName;
        _tmpTaskName = _cursor.getString(_cursorIndexOfTaskName);
        _result.setTaskName(_tmpTaskName);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
