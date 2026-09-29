package top.yukonga.scripta.editor

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.intl.Locale
import top.yukonga.scripta.editor.menu.EditorContextAction

@Immutable
data class EditorStrings(
    // Context Actions
    val undo: String,
    val redo: String,
    val cut: String,
    val copy: String,
    val paste: String,
    val selectAll: String,
    // Find & Replace
    val find: String,
    val replaceWith: String,
    val replace: String,
    val replaceAll: String,
    val invalidRegex: String,
    val noResults: String,
    val wholeWord: String,
    // Goto Line
    val gotoLine: String,
    val goto: String,
    val totalLines: (Int) -> String,
) {
    companion object {
        val English = EditorStrings(
            undo = "Undo",
            redo = "Redo",
            cut = "Cut",
            copy = "Copy",
            paste = "Paste",
            selectAll = "Select All",
            find = "Find",
            replaceWith = "Replace with",
            replace = "Replace",
            replaceAll = "Replace All",
            invalidRegex = "Invalid regex",
            noResults = "No results",
            wholeWord = "Word",
            gotoLine = "Go to line",
            goto = "Go",
            totalLines = { "Total $it lines" },
        )

        val Indonesian = EditorStrings(
            undo = "Urungkan",
            redo = "Ulangi",
            cut = "Potong",
            copy = "Salin",
            paste = "Tempel",
            selectAll = "Pilih Semua",
            find = "Cari",
            replaceWith = "Ganti dengan",
            replace = "Ganti",
            replaceAll = "Ganti Semua",
            invalidRegex = "Regex tidak valid",
            noResults = "Tidak ada hasil",
            wholeWord = "Kata",
            gotoLine = "Lompat ke baris",
            goto = "Lompat",
            totalLines = { "Total $it baris" },
        )

        val ChineseSimplified = EditorStrings(
            undo = "撤销",
            redo = "重做",
            cut = "剪切",
            copy = "复制",
            paste = "粘贴",
            selectAll = "全选",
            find = "查找",
            replaceWith = "替换为",
            replace = "替换",
            replaceAll = "全部替换",
            invalidRegex = "无效正则",
            noResults = "无结果",
            wholeWord = "词",
            gotoLine = "跳转到行",
            goto = "跳转",
            totalLines = { "共 $it 行" },
        )

        val ChineseTraditional = EditorStrings(
            undo = "復原",
            redo = "重做",
            cut = "剪下",
            copy = "複製",
            paste = "貼上",
            selectAll = "全選",
            find = "尋找",
            replaceWith = "取代為",
            replace = "取代",
            replaceAll = "全部取代",
            invalidRegex = "無效正規表示式",
            noResults = "無結果",
            wholeWord = "詞",
            gotoLine = "跳轉到行",
            goto = "跳轉",
            totalLines = { "共 $it 行" },
        )

        val Russian = EditorStrings(
            undo = "Отменить",
            redo = "Повторить",
            cut = "Вырезать",
            copy = "Копировать",
            paste = "Вставить",
            selectAll = "Выбрать все",
            find = "Найти",
            replaceWith = "Заменить на",
            replace = "Заменить",
            replaceAll = "Заменить все",
            invalidRegex = "Неверный regex",
            noResults = "Нет результатов",
            wholeWord = "Слово",
            gotoLine = "Перейти к строке",
            goto = "Перейти",
            totalLines = { "Всего строк: $it" },
        )

        @Composable
        fun auto(locale: Locale = Locale.current): EditorStrings {
            val lang = locale.language
            val region = locale.region
            return when {
                lang.equals("zh", ignoreCase = true) -> {
                    if (region.equals("TW", ignoreCase = true) || region.equals("HK", ignoreCase = true) || region.equals("MO", ignoreCase = true)) {
                        ChineseTraditional
                    } else {
                        ChineseSimplified
                    }
                }
                lang.equals("in", ignoreCase = true) || lang.equals("id", ignoreCase = true) -> Indonesian
                lang.equals("ru", ignoreCase = true) -> Russian
                else -> English
            }
        }
    }
}

val LocalEditorStrings = staticCompositionLocalOf { EditorStrings.English }

fun EditorStrings.labelFor(action: EditorContextAction): String = when (action) {
    EditorContextAction.Undo -> undo
    EditorContextAction.Redo -> redo
    EditorContextAction.Cut -> cut
    EditorContextAction.Copy -> copy
    EditorContextAction.Paste -> paste
    EditorContextAction.SelectAll -> selectAll
}
