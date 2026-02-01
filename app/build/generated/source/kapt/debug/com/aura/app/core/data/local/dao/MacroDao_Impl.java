package com.aura.app.core.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.aura.app.core.data.local.entity.MacroEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MacroDao_Impl implements MacroDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MacroEntity> __insertionAdapterOfMacroEntity;

  private final EntityDeletionOrUpdateAdapter<MacroEntity> __deletionAdapterOfMacroEntity;

  public MacroDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMacroEntity = new EntityInsertionAdapter<MacroEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `macros` (`id`,`name`,`description`,`createdAt`,`stepsJson`) VALUES (?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final MacroEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescription());
        }
        statement.bindLong(4, entity.getCreatedAt());
        if (entity.getStepsJson() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getStepsJson());
        }
      }
    };
    this.__deletionAdapterOfMacroEntity = new EntityDeletionOrUpdateAdapter<MacroEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `macros` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final MacroEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
  }

  @Override
  public Object insertMacro(final MacroEntity macro, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMacroEntity.insert(macro);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteMacro(final MacroEntity macro, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfMacroEntity.handle(macro);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<MacroEntity>> getAllMacros() {
    final String _sql = "SELECT * FROM macros ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"macros"}, new Callable<List<MacroEntity>>() {
      @Override
      @NonNull
      public List<MacroEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfStepsJson = CursorUtil.getColumnIndexOrThrow(_cursor, "stepsJson");
          final List<MacroEntity> _result = new ArrayList<MacroEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final MacroEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final String _tmpStepsJson;
            if (_cursor.isNull(_cursorIndexOfStepsJson)) {
              _tmpStepsJson = null;
            } else {
              _tmpStepsJson = _cursor.getString(_cursorIndexOfStepsJson);
            }
            _item = new MacroEntity(_tmpId,_tmpName,_tmpDescription,_tmpCreatedAt,_tmpStepsJson);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getMacroById(final String id, final Continuation<? super MacroEntity> $completion) {
    final String _sql = "SELECT * FROM macros WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<MacroEntity>() {
      @Override
      @Nullable
      public MacroEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfStepsJson = CursorUtil.getColumnIndexOrThrow(_cursor, "stepsJson");
          final MacroEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final String _tmpStepsJson;
            if (_cursor.isNull(_cursorIndexOfStepsJson)) {
              _tmpStepsJson = null;
            } else {
              _tmpStepsJson = _cursor.getString(_cursorIndexOfStepsJson);
            }
            _result = new MacroEntity(_tmpId,_tmpName,_tmpDescription,_tmpCreatedAt,_tmpStepsJson);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
