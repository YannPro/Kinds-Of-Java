package com.yannyao.demo.mybatis_generator.mapper;

import com.yannyao.demo.mybatis_generator.domain.YmShip;
import com.yannyao.demo.mybatis_generator.domain.YmShipExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface YmShipMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ym_ship
     *
     * @mbggenerated
     */
    int countByExample(YmShipExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ym_ship
     *
     * @mbggenerated
     */
    int deleteByExample(YmShipExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ym_ship
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ym_ship
     *
     * @mbggenerated
     */
    int insert(YmShip record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ym_ship
     *
     * @mbggenerated
     */
    int insertSelective(YmShip record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ym_ship
     *
     * @mbggenerated
     */
    List<YmShip> selectByExampleWithRowbounds(YmShipExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ym_ship
     *
     * @mbggenerated
     */
    List<YmShip> selectByExample(YmShipExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ym_ship
     *
     * @mbggenerated
     */
    YmShip selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ym_ship
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") YmShip record, @Param("example") YmShipExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ym_ship
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") YmShip record, @Param("example") YmShipExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ym_ship
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(YmShip record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ym_ship
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(YmShip record);
}