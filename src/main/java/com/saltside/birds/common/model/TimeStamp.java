package com.saltside.birds.common.model;

import org.apache.commons.lang.ArrayUtils;
import org.hibernate.EmptyInterceptor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Muks
 */

@MappedSuperclass
public class TimeStamp extends EmptyInterceptor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date added;

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames,
                          org.hibernate.type.Type[] types) {
        try {
            int indexOf = ArrayUtils.indexOf(propertyNames, "added");
            if (state[indexOf] == null) {
                state[indexOf] = new Date();
            }
        } catch (Exception e) {
            // Do nothing
        }

        return true;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    @PrePersist
    protected void onCreate() {
        added = new Date();
    }
}
