package com.newkdd.admin.web;

import com.github.pagehelper.PageInfo;
import com.newkdd.admin.model.po.SysUserPO;
import com.newkdd.admin.model.vo.SysUserVO;
import com.newkdd.admin.service.ISysUserService;
import com.newkdd.framework.basic.BasicController;
import com.newkdd.framework.basic.PageDTO;
import com.newkdd.framework.util.BeanUtils;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户控制层
 * @author mike.miao
 *
 */
@RestController
@RequestMapping("/v1/sys_users")
@Api(value = "SysUserController", description="用户管理接口")
public class SysUserController extends BasicController{
    @Autowired
    private ISysUserService sysUserService;

    /**
     * 根据用户编码获取用户信息
     * @param userId * 用户编码
     * @param request
     * @return
     */
    @ApiOperation(value = "根据编码获取用户信息", notes = "根据编码获取用户信息")
    @GetMapping(value = "{userId}", produces = {"application/json;charset=UTF-8"})
    public SysUserPO getUser(@PathVariable String userId, HttpServletRequest request) {
        SysUserPO sysUserPO = sysUserService.selectByPrimaryKey(userId);
        return sysUserPO;
    }

    /**
     * 用户信息导出
     * @return
     */
    @ApiOperation(value = "根据编码获取用户信息", notes = "根据编码获取用户信息")
    @GetMapping(value = "export", produces = {"application/json;charset=UTF-8"})
    public ResponseEntity<byte[]> exportUser(@RequestParam(defaultValue = "") String keywords,
                                             @RequestParam(required = false) String sortby,
                                             @RequestParam(required = false,defaultValue = "asc") String order,
                                             String username,String realname,String phone,String email) {
        SysUserPO sysUserPO = new SysUserPO();
        sysUserPO.setUsername(username);
        sysUserPO.setRealname(realname);
        sysUserPO.setEmail(email);
        sysUserPO.setPhone(phone);
        sysUserPO.setKeywords(keywords);
        sysUserPO.setSortby(sortby);
        sysUserPO.setOrder(order);
        List<SysUserPO> sysUserPOS = sysUserService.select(sysUserPO);
        HttpHeaders headers = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建Excel文档
            HSSFWorkbook workbook = new HSSFWorkbook();
            //2.创建文档摘要
            workbook.createInformationProperties();
            //3.获取文档信息，并配置
            DocumentSummaryInformation dsi = workbook.getDocumentSummaryInformation();
            //3.1文档类别
            dsi.setCategory("员工信息");
            //3.2设置文档管理员
            dsi.setManager("NKOP");
            //3.3设置组织机构
            dsi.setCompany("NKOP集团");
            //4.获取摘要信息并配置
            SummaryInformation si = workbook.getSummaryInformation();
            //4.1设置文档主题
            si.setSubject("员工信息表");
            //4.2.设置文档标题
            si.setTitle("员工信息");
            //4.3 设置文档作者
            si.setAuthor("NKOP集团");
            //4.4设置文档备注
            si.setComments("备注信息暂无");
            //创建Excel表单
            HSSFSheet sheet = workbook.createSheet("XXX集团员工信息表");
            //创建日期显示格式
            HSSFCellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
            //创建标题的显示样式
            HSSFCellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            //定义列的宽度
            sheet.setColumnWidth(0, 12 * 256);//账号
            sheet.setColumnWidth(1, 16 * 256);//姓名
            sheet.setColumnWidth(2, 12 * 256);//微信账号
            sheet.setColumnWidth(3, 12 * 256);//电话
            sheet.setColumnWidth(4, 20 * 256);//邮箱
            sheet.setColumnWidth(5, 12 * 256);//创建人
            sheet.setColumnWidth(6, 12 * 256);//创建时间
            //5.设置表头
            HSSFRow headerRow = sheet.createRow(0);
            HSSFCell cell0 = headerRow.createCell(0);
            cell0.setCellValue("账号");
            cell0.setCellStyle(headerStyle);
            HSSFCell cell1 = headerRow.createCell(1);
            cell1.setCellValue("姓名");
            cell1.setCellStyle(headerStyle);
            HSSFCell cell2 = headerRow.createCell(2);
            cell2.setCellValue("微信账号");
            cell2.setCellStyle(headerStyle);
            HSSFCell cell3 = headerRow.createCell(3);
            cell3.setCellValue("电话");
            cell3.setCellStyle(headerStyle);
            HSSFCell cell4 = headerRow.createCell(4);
            cell4.setCellValue("邮箱");
            cell4.setCellStyle(headerStyle);
            HSSFCell cell5 = headerRow.createCell(5);
            cell5.setCellValue("创建人");
            cell5.setCellStyle(headerStyle);
            HSSFCell cell6 = headerRow.createCell(6);
            cell6.setCellValue("创建时间");
            cell6.setCellStyle(headerStyle);
            //6.装数据
            for (int i = 0; i < sysUserPOS.size(); i++) {
                HSSFRow row = sheet.createRow(i + 1);
                SysUserPO emp = sysUserPOS.get(i);
                row.createCell(0).setCellValue(emp.getUsername());
                row.createCell(1).setCellValue(emp.getRealname());
                row.createCell(2).setCellValue(emp.getWXID());
                row.createCell(3).setCellValue(emp.getPhone());
                row.createCell(4).setCellValue(emp.getEmail());
                row.createCell(5).setCellValue(emp.getCreatedBy());
                HSSFCell birthdayCell = row.createCell(6);
                birthdayCell.setCellValue(emp.getCreatedDate());
                birthdayCell.setCellStyle(dateCellStyle);
            }
            headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", new String("员工信息表.xls".getBytes("UTF-8"), "iso-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            baos = new ByteArrayOutputStream();
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }

    @ApiOperation(value = "根据查询条件获取用户分页数据", notes = "根据查询条件获取用户分页数据")
    @GetMapping(value = "user_page", produces = {"application/json;charset=UTF-8"})
    public PageDTO getUserPage(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(name = "per_page",defaultValue = "10") Integer perPage,
                               @RequestParam(defaultValue = "") String keywords,
                               @RequestParam(required = false) String sortby,
                               @RequestParam(required = false,defaultValue = "asc") String order,
                               String username,String realname,String phone,String email
                               ){
        SysUserPO sysUserPO = new SysUserPO();
        sysUserPO.setUsername(username);
        sysUserPO.setRealname(realname);
        sysUserPO.setEmail(email);
        sysUserPO.setPhone(phone);
        sysUserPO.setKeywords(keywords);
        sysUserPO.setSortby(sortby);
        sysUserPO.setOrder(order);
        PageInfo<SysUserPO> pageInfo = sysUserService.selectPage(page,perPage,sysUserPO);
        PageDTO<SysUserVO> pageDTO = getPage(pageInfo,perPage);
        return pageDTO;
    }

    /**
     * 保存系统用户
     * @param request
     * @return
     */
    @ApiOperation(value = "根据编码获取用户信息", notes = "根据编码获取用户信息")
    @PostMapping(produces = {"application/json;charset=UTF-8"})
    public SysUserVO save(SysUserVO sysUser, HttpServletRequest request) {
        SysUserPO sysUserPO = BeanUtils.copyObject(sysUser,SysUserPO.class);
        sysUserService.save(sysUserPO);
        return BeanUtils.copyObject(sysUserPO,SysUserVO.class);
    }

    /**
     * 保存系统用户
     * @param request
     * @return
     */
    @ApiOperation(value = "动态更新用户信息", notes = "动态更新用户信息")
    @PutMapping(produces = {"application/json;charset=UTF-8"})
    public SysUserVO update(SysUserVO sysUser, HttpServletRequest request) {
        SysUserPO sysUserPO = BeanUtils.copyObject(sysUser,SysUserPO.class);
        sysUserService.updateByPrimaryKeySelective(sysUserPO);
        return BeanUtils.copyObject(sysUserPO,SysUserVO.class);
    }


    /**
     * 删除系统用户
     * @param request
     * @return
     */
    @ApiOperation(value = "动态更新用户信息", notes = "动态更新用户信息")
    @DeleteMapping(value = "{ids}", produces = {"application/json;charset=UTF-8"})
    public Integer delete(@PathVariable String ids, HttpServletRequest request) {
        return sysUserService.logicDelete(ids);
    }
}
