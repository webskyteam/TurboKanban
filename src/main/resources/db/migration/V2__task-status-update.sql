UPDATE task SET process_status = 'TODO' WHERE process_status='todo';
UPDATE task SET process_status = 'IN_PROGRESS' WHERE process_status='doing';
UPDATE task SET process_status = 'DONE' WHERE process_status='done';
UPDATE task SET process_status = 'ARCHIVE' WHERE process_status='archive';
