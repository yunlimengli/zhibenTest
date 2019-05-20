package com.usa.zhiben.mapper.web.file;

import com.usa.zhiben.bean.web.file.FileList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FileListMapper {
    int deleteByPrimaryKey(@Param("id") Long id, @Param("fileNo") String fileNo);

    int insert(FileList record);

    FileList selectByPrimaryKey(@Param("id") Long id, @Param("fileNo") String fileNo);

    List<FileList> selectAll();

    int updateByPrimaryKey(FileList record);

    /**
     * 更新文件上传的状态值
     * @param fileNo
     * @param storageServerNo
     * @param status
     * @return
     */
    int updateFileDownStatus(@Param("fileNo") String fileNo, @Param("serverNo") String storageServerNo,@Param("saveRoot") String saveRoot,@Param("status") int status);
}