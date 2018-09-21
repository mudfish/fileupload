package com.dylan.common.fileupload.repository;

import com.dylan.common.fileupload.entity.*;
import org.springframework.stereotype.*;
import org.springframework.data.repository.query.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;

@Repository
public interface FileInfoRepository extends JpaRepository<FileInfo, Long>
{
    @Query(value = "select * from t_fileinfo t where t.real_file_name like %:fileName%", nativeQuery = true)
    Page<FileInfo> findByFileName(@Param("fileName")  String fileName,  Pageable pageable);
}
